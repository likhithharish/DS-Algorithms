package Recursion;

public class RopeCutting {

    public static int ropeCuttingLength(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = Math.max(ropeCuttingLength(n - a, a, b, c), ropeCuttingLength(n - b, a, b, c));
        res = Math.max(res, ropeCuttingLength(n - c, a, b, c));

        if (res == -1) {
            return -1;
        }

        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(ropeCuttingLength(23, 12, 9, 11));
        System.out.println(ropeCuttingLength(5, 2, 5, 1));
    }
}
