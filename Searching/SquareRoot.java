package Searching;

public class SquareRoot {
    // Find square root of number without using inbuilt lib
    // Idea - bonary search
    public static int squareRoot(int x) {
        long sq;
        int low = 0, high = x, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            sq = (long) mid * mid;
            if (sq == x) {
                return mid;
            } else if (sq > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(4));
        System.out.println(squareRoot(5));
        System.out.println(squareRoot(8));
    }
}
