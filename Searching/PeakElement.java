package Searching;

public class PeakElement {
    // Given an unsorted array, find index of peak element ( greater than its
    // neighbours)
    public static int peakElement(int[] nums) {
        // Naive approach - O(n)
        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return -1;
    }

    public static int peakEfficinetSol(int[] nums) {
        // modified binary search
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((mid == 0 || nums[mid - 1] <= nums[mid])
                    && (mid == n - 1 || nums[mid + 1] <= nums[mid])) {
                return mid;
            }
            if (mid > 0 && nums[mid - 1] >= nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(peakEfficinetSol(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
    }
}
