package Hashing;

import java.util.HashMap;

public class ContiguousArray {
    // Given a binary array, find the max length of a subarray with
    // equal number of 0s and 1s

    public static int naiveSolution(int[] arr) {

        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int count0 = 0;
            int count1 = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0) {
                    count0 += 1;
                } else {
                    count1 += 1;
                }
                if (count0 == count1) {
                    res = Math.max(res, count0 + count1);
                }
            }
        }
        return res;
    }

    public static int efficientSolution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int prefixSum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (prefixSum == 0) {
                res = i + 1;
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
            if (map.containsKey(prefixSum)) {
                res = Math.max(res, i - map.get(prefixSum));
            }
        }
        return (res);
    }

    public static void main(String[] args) {
        System.out.println(naiveSolution(new int[] { 0, 1, 1, 0, 1, 1, 0, 0 }));
    }
}
