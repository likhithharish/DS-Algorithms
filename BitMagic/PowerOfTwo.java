package BitMagic;

public class PowerOfTwo {
    // Given number n, check if it is power of two

    public static boolean naiveSolution(int n) {
        // count number of bits , if its 1, then it is yes.
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res += 1;
        }
        return (res == 1);
    }

    public static void main(String[] args) {
        System.out.println(naiveSolution(1));
    }
}
