package Searching;

public class TwoPointerApproach {
    // Given a sorted array,
    // find if there is a pair whose sum is equal to given sum.
    public static boolean searchSum(int[] nums, int sum) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            if (nums[low] + nums[high] == sum) {
                return true;
            } else if (nums[low] + nums[high] > sum) {
                high--;
            } else {
                low++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchSum(new int[] { 2, 5, 8, 12, 30 }, 17));
    }
}
