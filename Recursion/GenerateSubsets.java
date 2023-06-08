package Recursion;

public class GenerateSubsets {
    public static void generateSubsets(String s, String curr, int i) {
        if (i == s.length()) {
            System.out.print(curr + " ");
            return;
        }
        generateSubsets(s, curr, i + 1);
        generateSubsets(s, curr + s.charAt(i), i + 1);
    }

    public static void main(String[] args) {
        generateSubsets("ABC", "", 0);
    }
}
