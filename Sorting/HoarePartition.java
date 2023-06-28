package Sorting;

import java.util.Arrays;

public class HoarePartition {
    public static int lometoPartition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l - 1, j = h + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                System.out.println(Arrays.toString(arr));
                return j;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(lometoPartition(new int[] { 9, 8, 3, 12, 10, 6 }, 0, 5));
        // Output : [6, 8, 3, 12, 10, 9] index : 2
    }
}
