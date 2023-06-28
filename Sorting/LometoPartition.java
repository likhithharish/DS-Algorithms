package Sorting;

import java.util.Arrays;

public class LometoPartition {
    public static int[] partitionFromEnd(int[] arr, int pivot) {
        // pivot always at the end case
        int i = -1;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap elem to small partition.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;

        return arr;
    }

    public static int[] lometoPartition(int[] arr, int pivot) {
        // pivot can be anywhere - not just end.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == pivot) {
                // swapping pivot to last position.
                int temp = arr[i];
                arr[i] = arr[arr.length - 1];
                arr[arr.length - 1] = temp;
            }
        }
        arr = partitionFromEnd(arr, pivot);
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(lometoPartition(new int[] { 3, 8, 6, 12, 10, 9 }, 10)));
    }
}
