package Recursion;

public class SubsetSum {
    public static int subsetSum(int[] arr, int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        // left + right
        return subsetSum(arr, n - 1, sum) + subsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    public static void main(String[] args) {
        System.out.println(subsetSum(new int[] { 1, 2, 3, 4 }, 4, 5));
    }
}
