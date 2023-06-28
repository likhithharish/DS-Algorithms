package Sorting;

import java.util.Arrays;

public class MergeFunction {
    // sort the whole array.
    // low-mid -> one part is sorted, mid+1 -high -> second part is sorted.
    // Sort from low to high

    public static int[] mergeFunction(int[] arr, int low, int mid, int high) {
        int[] res = new int[arr.length];
        int i = low, j = mid + 1, r = 0;
        while (i < mid + 1 && j < high + 1) {
            if (arr[i] <= arr[j]) {
                res[r] = arr[i];
                i++;
            } else {
                res[r] = arr[j];
                j++;
            }
            r++;
        }
        while (i < mid + 1) {
            res[r] = arr[i];
            i++;
            r++;
        }
        while (j < high + 1) {
            res[r] = arr[j];
            j++;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeFunction(new int[] { 10, 15, 20, 11, 30 }, 0, 2, 4)));
        System.out.println(Arrays.toString(mergeFunction(new int[] { 5, 8, 12, 14, 7 }, 0, 3, 4)));
        System.out.println(Arrays.toString(mergeFunction(new int[] { 1, 2, 3, 3, 4, 5 }, 0, 2, 5)));
    }
}
