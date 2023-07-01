package Hashing;

import java.util.HashSet;

public class SubArrayGivenSum {
    public static boolean subArrayGivenSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;
        for (int i : arr) {
            prefixSum += i;
            if (set.contains(prefixSum - sum)) {
                return true;
            }
            if (prefixSum == sum) {
                // whole array sum = sum
                return true;
            }
            set.add(prefixSum);
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2 };
        System.out.println(subArrayGivenSum(arr, 6));
    }
}
