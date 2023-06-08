package BitMagic;

public class KthBitCheck {
    // for given n, check if kth bit is set (1)

    public static boolean isKthBitSet(int n, int k) {
        return (n & (int) Math.pow(2, k - 1)) != 0;
    }

    public static boolean naiveSolutionTwo(int n, int k) {
        for (int i = 0; i < (k - 1); i++) {
            n = n / 2;
        }

        return (n & 1) != 0;
    }

    public static boolean leftShiftEffiSol(int n, int k) {
        int x = 1 << (k - 1);

        return (n & x) != 0;
    }

    public static boolean rightShiftEffiSol(int n, int k) {
        int x = (n >> (k - 1));

        return (x & 1) != 0;
    }

    public static void main(String[] args) {
        System.out.println(isKthBitSet(8, 2));
        System.out.println(naiveSolutionTwo(8, 2));
    }
}
