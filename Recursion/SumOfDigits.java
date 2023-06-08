package Recursion;

public class SumOfDigits {
    public static int sumOfDigits(int n) {
        if (n <= 9) {
            return n;
        }

        return n % 10 + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(9987));
    }
}
