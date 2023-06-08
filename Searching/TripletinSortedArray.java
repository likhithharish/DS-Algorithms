package Searching;

public class TripletinSortedArray {
    // Given a sorted array and a sum,
    // Find a triplet whose sum equals given sum
    public static boolean findTriplet(int[] nums, int sum) {
        for (int i = 0; i < nums.length; i++) {
            int target = sum - nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            while (low <= high) {
                if (nums[low] + nums[high] == target) {
                    return true;
                } else if (nums[low] + nums[high] > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 8, 9, 20 };
        System.out.println(findTriplet(arr, 9));
    }
}
