package Searching;

public class CountOccurences {
    /*
     * Given a sorted array with duplicates , count the occurancies of search
     * element
     */

    public static int countOccurances(int[] nums, int target) {
        // first occr of element
        int firstOcc = firstOccurence(nums, target);
        if (firstOcc == -1) {
            return 0;// element do not exist;
        }
        return (lastOccurance(nums, target) - firstOcc + 1);
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

    public static int lastOccurance(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid != nums.length - 1 && nums[mid + 1] != nums[mid]) {
                    return mid;

                } else if (mid == nums.length - 1 && nums[mid] == target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(countOccurances(new int[] { 10, 20, 20, 20, 30, 30, 30, 30, 40 }, 30));
    }
}
