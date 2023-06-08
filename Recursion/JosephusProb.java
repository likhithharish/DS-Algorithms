package Recursion;

public class JosephusProb {
    // Josephus problem
    public static int josephusProb(int n, int k) {
        if (n == 1) {
            return 0;
        }

        return (josephusProb(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        System.out.println(josephusProb(7, 3));
    }
}
