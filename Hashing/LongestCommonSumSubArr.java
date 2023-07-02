package Hashing;

import java.util.HashMap;

public class LongestCommonSumSubArr {
    // Given two binary arrays , find the longest subarray with common sum.
    static int longestCommonSum(int[] arr1, int[] arr2) {
        // Find difference between the two
        int n = arr1.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = arr1[i] - arr2[i];

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0; // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];

            // To handle sum=0 at last index
            if (sum == 0)
                max_len = i + 1;

            // If this sum is seen before,
            // then update max_len if required
            if (hM.containsKey(sum))
                max_len = Math.max(max_len, i - hM.get(sum));

            else // Else put this sum in hash table
                hM.put(sum, i);
        }
        return max_len;
    }

    public static void main(String[] args) {
        int[] nums1 = { 0, 0, 0 };
        int[] nums2 = { 0, 0, 0 };
        System.out.println(longestCommonSum(nums1, nums2));
    }
}
