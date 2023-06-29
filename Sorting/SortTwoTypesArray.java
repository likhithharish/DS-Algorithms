package Sorting;

import java.util.Arrays;

public class SortTwoTypesArray {
    // Given an array containing two types of valus (even,odd) , (positive,
    // negative)etc.
    // Modify the array in two parts with sorted halfs (sorted even - sorted odds)
    // Eg: {15,14,13,12} => {12,14,13,15}

    public static int[] sortTwoTypes(int[] arr) {
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        Arrays.sort(arr, 0, i);
        Arrays.sort(arr, i, arr.length);
        return arr;
    }

    public static int[] efficientWay(int[] arr) {
        // Using partition logic - segregating only doesnt sort.
        int i = -1, j = arr.length;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] >= 0);
            if (i >= j) {
                return arr;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(efficientWay(new int[] { 18, -3, -2, 15, -1 })));
    }
}
