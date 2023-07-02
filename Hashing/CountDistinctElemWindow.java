package Hashing;

import java.util.HashMap;

public class CountDistinctElemWindow {
    // Given a array and a window of size k. Find the count of
    // Distinct elements in each window. total windows = (n-k+1);
    public static void printDistinct(int arr[], int n, int k) {
        // Naive Approach
        for (int i = 0; i <= n - k; i++) {
            int count = 0;
            for (int j = 0; j < k; j++) {
                boolean flag = false;
                for (int p = 0; p < j; p++) {
                    if (arr[i + j] == arr[i + p]) {
                        flag = true;
                        break;
                    }
                }
                if (flag == false)
                    count++;

            }
            System.out.print(count + " ");
        }
    }

    public static void printDistinctEff(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        System.out.print(map.size() + " ");
        for (int i = 1; i <= nums.length - k; i++) {
            if (map.containsKey(nums[i - 1])) {
                map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
                if (map.get(nums[i - 1]) == 0) {
                    map.remove(nums[i - 1]);
                }
            }
            if (map.containsKey(nums[i + k - 1])) {
                map.put(nums[i + k - 1], map.get(nums[i + k - 1]) + 1);
            } else {
                map.put(nums[i + k - 1], 1);
            }
            System.out.print(map.size() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40 };
        printDistinctEff(arr, 3);
    }
}
