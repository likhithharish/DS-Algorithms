package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    static void bucketSort(int arr[], int k) {
        int n = arr.length;
        int max_val = arr[0];
        for (int i = 1; i < n; i++)
            max_val = Math.max(max_val, arr[i]);
        max_val++;

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            int idx = (arr[i] * k) / max_val;
            buckets.get(idx).add(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            Collections.sort(buckets.get(i));
        }

        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                arr[index++] = buckets.get(i).get(j);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 20, 80, 10, 85, 75, 99, 18 };
        bucketSort(arr, 5);
        System.out.println(Arrays.toString(arr));
    }
}
