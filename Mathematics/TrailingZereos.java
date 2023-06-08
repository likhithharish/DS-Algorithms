package Mathematics;

public class TrailingZereos {
    // Find the number of trailing zeroes in a number
    public static int naiveSolution(int n) {
        // Will lead to overload for n=20+ for example
        int fact = 1;
        for (int i = n; i >= 1; i--) {
            fact *= i;
        }

        int count = 0;
        while (fact % 10 == 0) {
            count++;
            fact = fact / 10;
        }
        return count;
    }

    public static int efficitentSol(int n) {
        // Count the number of 5's as 5*2=10
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res += n / i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(naiveSolution(10));
    }
}
