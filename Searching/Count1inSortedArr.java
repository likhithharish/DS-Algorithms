package Searching;

public class Count1inSortedArr {
    // Given sorted binary array, count the 1's in it.
    // Idea - find first occurence
    public static int countOne(int[] nums) {
        int firstOccIndex = firstOccurence(nums, 1);
        if (firstOccIndex == -1) {
            return 0;
        } // all 0's
        return (nums.length - firstOccIndex);
    }

    public static int firstOccurence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(countOne(new int[] { 0, 0, 1, 1, 1, 1, 1 }));
        System.out.println(countOne(new int[] { 1, 1, 1, 1 }));
        System.out.println(countOne(new int[] { 0, 0, 0 }));
    }
}
