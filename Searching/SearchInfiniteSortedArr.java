package Searching;

public class SearchInfiniteSortedArr {
    // Search element in infinte sized arr - UNBOUNDED BINARY SEARCH
    public static int findElem(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }
        int i = 1;
        while (arr[i] < target) {
            i = i * 2;
        }
        if (arr[i] == target) {
            return i;
        }
        return binarySearch(arr, target, i / 2 + 1, i - 1);
    }

    public static int binarySearch(int[] arr, int target, int low, int high) {
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

    public static void main(String[] args) {
        System.out.println(
                findElem(new int[] { 1, 2, 3, 4, 5, 10, 15, 20, 34, 56, 78, 99, 100, 125, 150, 245, 456 }, 101));
    }
}
