package Sorting;

import java.util.Arrays;

public class CountingSort {

    public static void naiveCountingSort(int[] arr, int k) {
        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }
        int a = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    arr[a] = i;
                    a++;
                }
            }

        }
    }

    public static void generalCountingSort(int[] arr, int k) {
        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 4, 1, 0, 1 };
        generalCountingSort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
