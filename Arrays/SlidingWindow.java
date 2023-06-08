package Arrays;

public class SlidingWindow {
    // FInd maximum sum of k consecutive elements
    public static int maxConsSum(int[] arr, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }
        maxSum = Math.max(currSum, maxSum);
        for (int i = k; i < arr.length; i++) {
            currSum = currSum + arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, currSum);

        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxConsSum(new int[] { 10, 5, -2, 20 }, 3));
    }
}
