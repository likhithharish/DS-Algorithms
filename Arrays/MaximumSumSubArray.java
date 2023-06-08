package Arrays;

public class MaximumSumSubArray {
    public static int maxSumSubArray(int[] arr) {
        int currSum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            res = Math.max(res, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[] { 2, 3, -8, 7, -1, 2, 3 }));
        System.out.println(maxSumSubArray(new int[] { 5, 8, 3 }));
        System.out.println(maxSumSubArray(new int[] { -6, -1, -8 }));// wrong
        System.out.println(maxSumSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));// 4
        System.out.println(maxSumSubArray(new int[] { 5, 4, -1, 7, 8 }));
        System.out.println(maxSumSubArray(new int[] { 1 }));

    }
}
