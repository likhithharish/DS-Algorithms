package Recursion;

/**
 * FactorialofNum
 */
public class FactorialofNum {

    public static int factorial(int n) {
        // not Tail recursive
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int factorial(int n, int k) {
        // Tail Recursive
        if (n == 0 || n == 1) {
            return k;
        }

        return factorial(n - 1, k * n);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial(4, 1));
    }
}