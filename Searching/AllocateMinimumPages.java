package Searching;

public class AllocateMinimumPages {
    /*
     * Given a array with n books size and arr[i] represent number of pages in each
     * book.
     * if there are k students and each should read only contiguous books, compute
     * the minimum posb value
     * for maximum no.of pages allocated for a student.
     */
    public static int naiveSolution(int[] arr, int n, int k) {
        // n - size of array pass it initially,k -no of students
        if (k == 1) {
            return sum(arr, 0, n - 1);
        }
        if (n == 1) {
            return arr[0];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            res = Math.min(res,
                    Math.max(naiveSolution(arr, i, k - 1), sum(arr, i, n - 1)));
        }
        return res;
    }

    public static int sum(int[] arr, int b, int e) {
        // b and e inclusive.
        int sum = 0;
        for (int i = b; i <= e; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int binarySearchSol(int[] arr, int k) {
        int n = arr.length;
        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            max = Math.max(arr[i], max);
        }
        int low = max, high = sum;
        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isFeasible(arr, k, mid)) {
                res = mid;
                high = mid - 1; // moving to left half
            } else {
                low = mid + 1; // move to right half
            }
        }
        return res;
    }

    public static boolean isFeasible(int[] arr, int k, int ans) {
        int req = 1, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > ans) {
                req++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return (req <= k);
    }

    public static void main(String[] args) {
        System.out.println(naiveSolution(new int[] { 10, 20, 30, 40 }, 4, 2));
        System.out.println(naiveSolution(new int[] { 10, 5, 30, 1, 2, 5, 10, 10 }, 7, 3));
        System.out.println(binarySearchSol(new int[] { 10, 20, 30, 40 }, 2));
        System.out.println(binarySearchSol(new int[] { 10, 5, 30, 1, 2, 5, 10, 10 }, 3));
    }
}
