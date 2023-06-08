package Searching;

public class MedianInSortedArray {
    // Given two sorted arrays, find the median of
    // a final array that comes from merging two arrays.

    public static double findMedian(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // Needs nums1 as smaller array, as bs in small array takes less time
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n1 = nums1.length, n2 = nums2.length;
        int begin = 0, end = n1;
        while (begin <= end) {
            int i1 = (begin + end) / 2;
            int i2 = ((n1 + n2 + 1) / 2) - i1;
            int min1 = (i1 == n1) ? Integer.MAX_VALUE : nums1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : nums1[i1 - 1];

            int min2 = (i2 == n2) ? Integer.MAX_VALUE : nums2[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : nums2[i2 - 1];

            if (max1 <= min2 && max2 <= min1) {
                if ((n1 + n2) % 2 == 0) {// even final length
                    return ((double) (Math.max(max1, max2) + Math.min(min1, min2)) / 2);
                } else {// odd final length
                    return ((double) Math.max(max1, max2));
                }
            } else if (max1 > max2) {
                end = i1 - 1; // move to left side
            } else {
                begin = i1 + 1; // Move to right side
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
