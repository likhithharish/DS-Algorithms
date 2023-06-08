package Searching;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
                ;
            }
            if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    // Recursive approach
    public static int binarySearchRec(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRec(arr, target, mid + 1, high);
        } else {
            return binarySearchRec(arr, target, low, mid - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] { 10, 20, 30, 40 }, 20));
        System.out.println(binarySearchRec(new int[] { 10, 20, 30, 40, 50 }, 40, 0, 4));
    }
}
