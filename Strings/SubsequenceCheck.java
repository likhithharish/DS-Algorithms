package Strings;

public class SubsequenceCheck {
    // Given two strings s1 and s2, check if s2 is subsequence of s1.
    public static boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return (j == s2.length());
    }

    public static boolean recursiveSol(String s1, String s2, int n, int m) {
        if (m == 0)
            return true;

        if (n == 0)
            return false;

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return recursiveSol(s1, s2, n - 1, m - 1);

        else
            return recursiveSol(s1, s2, n - 1, m);
    }

    public static void main(String[] args) {
        System.out.println(recursiveSol("ABCD", "AD", 4, 2));
    }
}
