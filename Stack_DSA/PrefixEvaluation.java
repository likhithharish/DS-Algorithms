package Stack_DSA;

import java.util.*;

public class PrefixEvaluation {

    public static int prefixEvaluation(String s) {
        String[] strs = s.split(" ");
        Deque<String> valSt = new ArrayDeque<>();
        int result = 0;
        for (int i = strs.length - 1; i >= 0; i--) {
            if (isOperand(strs[i])) {
                valSt.addLast(strs[i]);
            } else {
                System.out.println(Arrays.toString(valSt.toArray()));
                int int_val1 = Integer.valueOf(valSt.removeLast());
                int int_val2 = Integer.valueOf(valSt.removeLast());
                switch (strs[i]) {
                    case "+":
                        result = int_val2 + int_val1;
                        break;
                    case "-":
                        result = int_val2 - int_val1;
                        break;
                    case "*":
                        result = int_val2 * int_val1;
                        break;
                    case "/":
                        result = int_val2 / int_val1;
                        break;
                    default:
                        result = 0;
                }
                valSt.addFirst(String.valueOf(result));
            }
        }
        return result;
    }

    public static boolean isOperand(String s) {
        try {
            int k = Integer.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(prefixEvaluation("* + 10 2 + 4 5"));
    }
}
