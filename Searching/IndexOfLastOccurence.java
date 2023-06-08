package Searching;

public class IndexOfLastOccurence {
    // Given a sorted array , find index of last occurence of search element
    public static int indexOfLastOccurence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {

                if (mid != arr.length - 1 && arr[mid + 1] != arr[mid]) {
                    return mid;
                } else if (mid == arr.length - 1 && arr[mid] == target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOfLastOccurence(new int[] { 10, 20, 20, 30, 30, 30, 30, 40, 40, 50 }, 50));
    }
}
