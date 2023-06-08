package BitMagic;

public class CountBits {

    // Given number n, count the number of set bits in it
    public static int naiveCountBits(int n) {
        if (n == 0)
            return 0;
        int res = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                res++;
            } // this if can be -> res += (n&1)
            n = n / 2;
        }
        return res;
    }

    // Brian Kerningan Algorithm
    public static int efficientSolution(int n) {
        int res = 0;
        while (n > 0) {
            n = n & (n - 1);
            res += 1;
        }
        return res;
    }

    static int[] tbl = new int[256];

    static void initialize() {
        tbl[0] = 0;
        for (int i = 1; i < 256; i++) {
            tbl[i] = tbl[i & (i - 1)] + 1;
        }
    }

    public static int lookUpTableSol(int n) {
        return tbl[n & 255] + tbl[(n >> 8) & 255] + tbl[(n >> 16) & 255] + tbl[n >> 24];
    }

    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println(i);
            // Brain Kerningan Algorithm
            int count = 0;
            while (i > 0) {
                System.out.println("while:" + i);
                i = i & (i - 1);
                count += 1;
            }
            res[i] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(naiveCountBits(7));
        System.out.println(efficientSolution(1));
        initialize();
        System.out.println(lookUpTableSol(7));
        System.out.println(countBits(2).toString());
    }
}
