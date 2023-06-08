package Mathematics;

public class GCDofNumber {
    // FInd the GCD/HCF of a number

    public static int naiveSolution(int a, int b) {
        int min = (a < b) ? a : b;
        int res = 1;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                res = Math.max(res, i);
            }
        }
        return res;
    }

    public static int euclidAlgorithm(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a; // return b; also works
    }

    public static int modifyEuclidAlgo(int a, int b) {
        if (b == 0) {
            return a;
        }
        return modifyEuclidAlgo(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(modifyEuclidAlgo(100, 200));
    }
}
