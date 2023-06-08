package Arrays;

public class BuySellStockI {
    // Leetcode buy and sell stock 2 - 122
    public static int buyAndSellStock(int[] arr) {
        int currMin = arr[0];
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - currMin > 0) {
                res += arr[i] - currMin;
                currMin = arr[i];
            }
            currMin = Math.min(currMin, arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(buyAndSellStock(new int[] { 1, 5, 3, 1, 2, 8 }));
    }
}
