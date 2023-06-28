package Sorting;

import java.util.Arrays;

public class NaivePartition {
    // Naive partition logic for quick sort algo intro

    // Given a index p, partition the array around the index
    public static int[] naiveParition(int[] arr, int p) {
        int[] temp = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[p]) {
                temp[index] = arr[i];
                index++;
            }
        }
        temp[index] = arr[p];
        index++;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[p]) {
                temp[index] = arr[i];
                index++;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(naiveParition(new int[] { 3, 8, 6, 12, 10, 7 }, 3)));
    }
}
