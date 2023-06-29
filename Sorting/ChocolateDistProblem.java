package Sorting;

import java.util.Arrays;

public class ChocolateDistProblem {
    /*
     * Given an array where each index represents a bag of arr[i] chocolate pick 'm'
     * bags from array where difference of minimum chocolate bag to maxmimum choc
     * bag is
     * MINIMUM
     */
    public static int chocolateDist(int[] arr, int m) {
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length && (i + m - 1) < arr.length; i++) {
            res = Math.min(res, arr[i + m - 1] - arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 1, 9, 56, 7, 9, 12 };
        System.out.println(chocolateDist(arr, 5));
    }
}
