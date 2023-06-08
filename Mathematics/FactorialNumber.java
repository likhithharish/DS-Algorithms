package Mathematics;

public class FactorialNumber {
    // FInd factorial of a number.

    public static int naiveSolution(int n) {
        int res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
        }
        return res;
    }

    public static int recursiveSol(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return n * recursiveSol(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(naiveSolution(0));
        System.out.println(recursiveSol(3));
    }
}
