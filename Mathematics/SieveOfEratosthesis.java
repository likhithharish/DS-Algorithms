package Mathematics;

import java.util.*;

public class SieveOfEratosthesis {
    // Find all primes less than or equal to n

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void naiveSol(int n) {
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void efficientAlgo(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int i = 2; i * i <= n; i++) {
            if (arr[i]) {
                for (int j = i * 2; j <= n; j = j + i) {
                    arr[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void shortImpleAlgo(int n) {
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);

        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                System.out.print(i + " ");
                for (int j = i * i; j <= n; j = j + i) {
                    arr[j] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        naiveSol(23);
        System.out.println("");
        efficientAlgo(23);
        System.out.println("");
        shortImpleAlgo(23);
    }
}
