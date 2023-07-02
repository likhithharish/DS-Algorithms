package Hashing;

import java.util.HashMap;

public class LongestSubArrayGivenSum {
    // Given a array and sum, find the length of the longest subarray.

    public static int longestSubArrSum(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (preSum == sum) {
                // array starts with 0
                res = i + 1;
            }
            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            }
            if (map.containsKey(preSum - sum)) {
                res = Math.max(res, i - map.get(preSum - sum));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, -1, 0 };
        System.out.println(longestSubArrSum(arr, 0));
    }
}
