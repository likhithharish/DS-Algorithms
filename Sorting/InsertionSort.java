package Sorting;

import java.util.*;

public class InsertionSort {

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[] { 2, 0, 2, 1, 1, 0 })));
        System.out.println(Arrays.toString(insertionSort(new int[] { 1, 3, 4, 8, 1, 2 })));
    }
}
