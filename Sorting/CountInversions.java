package Sorting;

public class CountInversions {
    // Given an array, count the number of inversions in it.
    // A pair (arr[i], arr[j]) forms an inversion when i<j and arr[i] > arr[j]
    public static int naivecountInversions(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countInversions(int[] arr, int l, int r) {
        // based on merge sort
        int res = 0;
        if (r > l) {
            int m = l + (r - l) / 2;
            res += countInversions(arr, l, m);
            res += countInversions(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    public static int countAndMerge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }
        int res = 0, i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
                res += (n1 - i);
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(naivecountInversions(new int[] { 2, 4, 1, 3, 5 }));
        System.out.println(naivecountInversions(new int[] { 4, 3, 2, 1 }));
        System.out.println(countInversions(new int[] { 2, 4, 1, 3, 5 }, 0, 4));
        System.out.println(countInversions(new int[] { 4, 3, 2, 1 }, 0, 3));
        System.out.println(countInversions(new int[] { 1, 2, 3, 4 }, 0, 3));
        System.out.println(countInversions(new int[] { 2, 1, 3, 4, 5, 1 }, 0, 5));
    }
}
