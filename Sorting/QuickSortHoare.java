package Sorting;

import java.util.Arrays;

public class QuickSortHoare {
    // Quick sort using Hoare Partition
    public static int hoarePartition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l - 1, j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j)
                return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int p = hoarePartition(arr, l, h);
            quickSort(arr, l, p); // not p-1 unlike lometo
            quickSort(arr, p + 1, h);
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 8, 4, 7, 9, 3, 10, 5 };
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}
