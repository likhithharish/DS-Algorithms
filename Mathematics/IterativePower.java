package Mathematics;

public class IterativePower {
    // Compute power in logN with O(1) space
    // Binary Exponentiation

    public static int iterativePower(int x, int n) {
        int res = 1;
        while (n > 0) {
            if (n % 2 != 0) {
                res = res * x;

            }
            x = x * x;
            n = n / 2;
            System.out.println(n + " " + x + " " + res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(iterativePower(3, 4));
    }
}
