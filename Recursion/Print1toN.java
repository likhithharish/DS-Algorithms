package Recursion;

public class Print1toN {
    public static void print1ton(int n) {
        if (n == 0) {
            return;
        }
        print1ton(n - 1);
        System.out.print(n + " ");
    }

    public static void print1tonTail(int n, int k) {
        // Tail Recursive code
        if (n == 0) {
            return;
        }
        System.out.print(k + " ");
        print1tonTail(n - 1, k + 1);

    }

    public static void main(String[] args) {
        print1ton(4);
        System.out.println("");
        print1tonTail(4, 1);
    }
}
