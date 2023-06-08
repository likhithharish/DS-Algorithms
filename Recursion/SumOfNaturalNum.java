package Recursion;

public class SumOfNaturalNum {
    // Sum of natural num using Recursion
    public static int sumOfNaturalNum(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sumOfNaturalNum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfNaturalNum(3));
    }
}
