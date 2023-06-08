package Searching;

public class IndexOfFirstOccurence {
    // Given a sorted array, find index of first occurance of search element
    public static int firstOccurence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                // if (mid > 0 && arr[mid - 1] == target) {
                // while (arr[mid] == target) {
                // mid--;
                // }
                // return mid + 1;
                // } else {
                // return mid;
                // } - modify like below
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstOccurence(new int[] { 15, 15, 20, 20, 30, 30, 30, 40, 40, 40, 40, 50 }, 40));
    }
}
