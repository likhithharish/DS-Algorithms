package Sorting;

import java.util.Arrays;

public class MinDifferenceinArray {
    // Given an array find the minimum absolute difference in the array
    public static int minAbsDiff(int[] arr) {
        if (arr.length == 1) {
            return Integer.MAX_VALUE;
        }
        if (arr.length == 2) {
            return Math.abs(arr[0] - arr[1]);
        }
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            res = Math.min(res, Math.abs(arr[i] - arr[i - 1]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minAbsDiff(new int[] { 10, 3, 20, 12 }));
    }
}
