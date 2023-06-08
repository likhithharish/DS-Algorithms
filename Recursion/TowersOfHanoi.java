package Recursion;

public class TowersOfHanoi {

    public static void towersOfHanoi(int n, String A, String B, String C) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + A + "to " + C);
            return;
        }
        towersOfHanoi(n - 1, A, C, B);
        System.out.println("Move disk " + n + " from " + A + "to " + C);
        towersOfHanoi(n - 1, B, A, C);
    }

    public static void main(String[] args) {
        towersOfHanoi(3, "A", "B", "C");
    }
}
