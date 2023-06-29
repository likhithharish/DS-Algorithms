package Sorting;

import java.util.Arrays;

public class KthSmallestNumber {
    // Given an input array find the kth smallest number in it.
    public static int kthSmallestNum(int[] arr, int k) {
        // Naive - nlogn solution.
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static int optimizedSol(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int p = lometoPartition(arr, l, h);
            if (p == k - 1) {
                return arr[p];
            }
            if (p > k - 1) {
                h = p - 1;
            } else if (p < k - 1) {
                l = p + 1;
            }
        }
        return -1;
    }

    public static int lometoPartition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[h];
        arr[h] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 5, 9, 8, 4, 7, 1 };
        System.out.println(optimizedSol(arr, 2));
    }
}
