package Stack_DSA;

import java.util.*;

class Conversion {
    private Stack<Character> st;
    private StringBuilder output;
    private HashMap<Character, Integer> precedence = new HashMap<>();

    public Conversion() {
        st = new Stack<>();
        output = new StringBuilder();
        precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
    }

    public String infixToPostfix(String s) {
        for (char c : s.toCharArray()) {
            if (isOperand(c)) {
                output.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    char temp = st.peek();
                    output.append(temp);
                    st.pop();
                }
                if (!st.isEmpty() && st.peek() != '(') {
                    return "Invalid Expression";
                } else {
                    st.pop();
                }
            } else {
                // Operator
                System.out.println("Opeartor:" + c);
                while (!st.isEmpty() && checkPrecedence(c)) {
                    char a = st.pop();
                    output.append(a);
                }
                st.push(c);
                System.out.println(output.toString());
            }
        }

        // Handle rest of elem in stack
        while (!st.isEmpty()) {
            char a = st.peek();
            output.append(a);
            st.pop();
        }
        return output.toString();
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

public class InfixToPostfix {

    public static void main(String[] args) {
        Conversion con = new Conversion();
        String res = con.infixToPostfix("(a+b)*");
        System.out.println(res);
    }
}
