package Stack_DSA;

import java.util.*;

class EvaluationPostfix {
    private int result;
    private Stack<String> st = new Stack<>();

    public EvaluationPostfix() {
    }

    public int evaluate(String post) {
        String[] s = post.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (isOperand(s[i])) {
                st.push(s[i]);
            } else {
                if (!st.isEmpty()) {
                    int int_val1 = Integer.valueOf(st.pop());
                    int int_val2 = Integer.valueOf(st.pop());
                    switch (s[i]) {
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
                }
                st.push(String.valueOf(result));
            }
        }
        return Integer.valueOf(st.pop());
    }

    public boolean isOperand(String s) {
        try {
            int k = Integer.valueOf(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

public class PostfixEvaluation {
    public static void main(String[] args) {
        EvaluationPostfix p = new EvaluationPostfix();
        System.out.println(p.evaluate("10 2 + 3 *"));
    }
}
