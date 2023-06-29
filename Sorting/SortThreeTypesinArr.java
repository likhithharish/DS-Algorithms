package Sorting;

import java.util.Arrays;

public class SortThreeTypesinArr {

    public static int[] sortThreeTypes(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {// 2's
                swap(arr, mid, high);
                high--;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortThreeTypes(new int[] { 0, 1, 0, 2, 1, 2 })));
    }
}
