package Arrays;

public class BuySellStockII {
    public static int trappedRainWater(int[] arr) {
        int[] leftMax = new int[arr.length];
        leftMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }
        int rightMax = arr[arr.length - 1];
        int res = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            int val = Math.min(leftMax[i], rightMax) - arr[i];
            res += (val > 0) ? val : 0;
            rightMax = Math.max(arr[i], rightMax);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trappedRainWater(new int[] { 2, 0, 2 }));
        System.out.println(trappedRainWater(new int[] { 3, 0, 1, 2, 5 }));
        System.out.println(trappedRainWater(new int[] { 5, 3, 0, 1, 7, 2, 5 }));
    }
}
