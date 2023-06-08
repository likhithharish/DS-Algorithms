package Arrays;

public class PrefixSum {

    public static int[] pSum;

    public static int getSum(int[] arr, int l, int r) {
        if (pSum == null) {
            pSum = new int[arr.length];
            pSum[0] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                pSum[i] = arr[i] + pSum[i - 1];
            }
        }

        if (l == 0) {
            return pSum[r];
        }
        return pSum[r] - pSum[l - 1];
    }

    public static void main(String[] args) {
        System.out.println(getSum(new int[] { 2, 8, 3, 9, 6, 5, 4 }, 2, 6));

    }
}
