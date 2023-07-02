package Hashing;

import java.util.*;

public class LongestConsecutiveSubSequence {
    // Given a array, find the longest consecutive subsequence
    public static int longestConsSubseq(int[] nums) {
        // Using sorting
        if (nums.length <= 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int count = 1, res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                count += 1;
            } else {
                count = 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static int efficientMethod(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (set.contains(nums[i]) && !set.contains(nums[i] - 1)) {
                int val = nums[i];
                while (set.contains(val)) {
                    count++;
                    val += 1;
                }
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
