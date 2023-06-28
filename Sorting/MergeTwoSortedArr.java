package Sorting;

import java.util.*;

public class MergeTwoSortedArr {
    // Given two sorted arrays , merge them into new single sorted array

    public static int[] mergeSortedArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0, j = 0, r = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                res[r] = arr1[i];
                i++;
            } else {
                res[r] = arr2[j];
                j++;
            }
            r++;
        }

        while (i < arr1.length) {
            res[r] = arr1[i];
            i++;
            r++;
        }
        while (j < arr2.length) {
            res[r] = arr2[j];
            j++;
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(mergeSortedArray(new int[] { 1, 2, 3, 4 }, new int[] { 2, 3, 4, 5, 6 })));
    }
}
