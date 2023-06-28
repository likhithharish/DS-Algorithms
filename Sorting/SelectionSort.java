package Sorting;

import java.util.*;

public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // Swap min and first indexes.
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[] { 2, 0, 2, 1, 1, 0 })));
        System.out.println(Arrays.toString(selectionSort(new int[] { 1, 3, 4, 8, 1, 2 })));
    }
}
