package Hashing;

import java.util.HashSet;

public class SubArraywith0Sum {
    // given a array, check if the array has a subarray whose sum=0
    public static boolean subArrayZeroSum(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (set.contains(prefixSum)) {
                return true;
            }
            if (prefixSum == 0) {
                // whole array sum =0
                return true;
            }
            set.add(prefixSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 4, -3, 5, 1 };
        System.out.println(subArrayZeroSum(arr));
    }
}
