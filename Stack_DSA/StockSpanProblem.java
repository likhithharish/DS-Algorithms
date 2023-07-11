package Stack_DSA;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {

    public static int[] stockSpan(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            int span = (st.isEmpty()) ? (i + 1) : (i - st.peek());
            st.push(i);
            arr[i] = span;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        int[] res = stockSpan(arr);
        System.out.println(Arrays.toString(res));// [1, 2, 1, 2, 5, 1, 1, 1, 4, 10]
    }
}
