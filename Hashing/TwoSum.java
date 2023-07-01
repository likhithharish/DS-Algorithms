package Hashing;

import java.util.HashMap;

public class TwoSum {
    // Given array and sum, return true if a pair exists in the array with given sum

    public static boolean twoSum(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            int target = sum - i;
            if (map.containsKey(target)) {
                return true;
            } else {
                map.put(i, 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 6, 3 };
        int sum = 6;
        System.out.println(twoSum(arr, sum));
    }
}
