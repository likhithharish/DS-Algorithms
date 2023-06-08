package Recursion;

public class FibonacciNum {
    // Print nth fibonacci number when n>=0

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(3));
    }
}
