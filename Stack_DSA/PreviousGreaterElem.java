package Stack_DSA;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElem {

    public static int[] previousGreatest(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] res = new int[arr.length];
        res[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            int prevGreat = (st.isEmpty()) ? -1 : arr[st.peek()];
            st.push(i);
            res[i] = prevGreat;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 10, 8 };// { 15, 10, 18, 12, 4, 6, 2, 8 };
        int[] res = previousGreatest(arr);
        System.out.println(Arrays.toString(res));// [-1, 15, -1, 18, 12, 12, 6, 12]
    }
}
