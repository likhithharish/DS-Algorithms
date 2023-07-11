package Stack_DSA;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElem {

    public static int[] nextGreaterElem(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                arr[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            arr[st.peek()] = -1;
            st.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 15, 10, 8, 6, 12, 9, 18 };
        int[] res = nextGreaterElem(arr);
        System.out.println(Arrays.toString(res));// [15, 18, 12, 12, 12, 18, 18, -1]
    }
}
