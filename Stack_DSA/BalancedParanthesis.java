package Stack_DSA;

import java.util.Stack;

public class BalancedParanthesis {

    public static boolean isBalancedParanthesis(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.add(')');
            } else if (c == '[') {
                st.add(']');
            } else if (c == '{') {
                st.add('}');
            } else {
                if (st.isEmpty() || st.pop() != c) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isBalancedParanthesis("()"));
    }
}
