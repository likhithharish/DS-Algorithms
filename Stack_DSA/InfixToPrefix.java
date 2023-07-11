package Stack_DSA;

import java.util.*;

class PrefixConversion {
    private Stack<Character> st;
    private StringBuilder output;
    private HashMap<Character, Integer> precedence = new HashMap<>();

    public PrefixConversion() {
        st = new Stack<>();
        output = new StringBuilder();
        precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
    }

    public String infixToPrefix(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (isOperand(s.charAt(i))) {
                output.append(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                while (!st.isEmpty() && st.peek() != ')') {
                    char c = st.peek();
                    output.append(c);
                    System.out.println(output.toString());
                    st.pop();
                }
                System.out.println(Arrays.toString(st.toArray()));
                st.pop();
            } else {
                while (!st.isEmpty() && checkPrecedence(s.charAt(i))) {
                    char a = st.pop();
                    output.append(a);
                }
                st.push(s.charAt(i));
            }

        }
        // Handle rest of elem in stack
        while (!st.isEmpty()) {
            output.append(st.pop());
        }
        return output.reverse().toString();
    }

    public boolean checkPrecedence(char c) {
        int a, b;
        if (precedence.containsKey(c) && precedence.containsKey(st.peek())) {
            a = precedence.get(c);
            b = precedence.get(st.peek());
            return (a <= b);
        } else {
            return false;
        }
    }

    public boolean isOperand(char c) {
        return Character.isLetter(c);
    }

}

public class InfixToPrefix {
    public static void main(String[] args) {
        PrefixConversion s = new PrefixConversion();
        System.out.println(s.infixToPrefix("(x+y)*(z+w)"));
    }
}
