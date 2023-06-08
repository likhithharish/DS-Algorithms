package Mathematics;

public class AllDivisors {

    public static void naiveAllDivisors(int n) {
        System.out.print(1 + " ");
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void efficientSolution(int n) {

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != n / i) {
                    System.out.print(n / i + " ");
                }
            }
        }
    }

    public static void mostEffectiveSolution(int n) {
        int i; // declared like this since i should
        // start from root(n) in second for loop
        for (i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }

        for (; i <= n; i++) { // no initialisation of i
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        naiveAllDivisors(100);
        System.out.println("");
        efficientSolution(100);
        System.out.println("");
        mostEffectiveSolution(100);
    }
}
