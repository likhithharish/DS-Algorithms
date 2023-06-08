package Mathematics;

public class ComputePower {
    // Given x, n compute x^n

    public static int naivePower(int x, int n) {
        int res = 1;
        while (n >= 1) {
            res = res * x;
            n--;
        }
        return res;
    }

    public static int efficientSol(int x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        int temp = efficientSol(x, n / 2);
        temp = temp * temp;
        return (n % 2 == 0) ? temp : (temp * x);
    }

    public static void main(String[] args) {
        System.out.println(naivePower(3, 4));
        System.out.println(efficientSol(3, 4));
    }
}
