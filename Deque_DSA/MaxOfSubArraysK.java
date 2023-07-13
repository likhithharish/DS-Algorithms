package Deque_DSA;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// Find the maximum of all subarrays of size k;

public class MaxOfSubArraysK {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < k; ++i) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
        }
        System.out.println(dq);
        for (int i = k; i < nums.length; ++i) {
            res[index] = nums[dq.peek()];
            index++;
            while ((!dq.isEmpty()) && dq.peek() <= i - k)
                dq.removeFirst();

            while ((!dq.isEmpty()) && nums[i] >= nums[dq.peekLast()])
                dq.removeLast();

            dq.addLast(i);
        }
        res[index] = dq.peek();
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 9, 11 };
        int[] res = maxSlidingWindow(arr, 3);
        System.out.println(Arrays.toString(res));
    }
}
