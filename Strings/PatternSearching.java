package Strings;

public class PatternSearching {

    public static void patSearchinng(String txt, String pat) {
        // Complete naive
        int m = pat.length();
        int n = txt.length();
        for (int i = 0; i <= (n - m); i++) {
            int j;
            for (j = 0; j < m; j++)
                if (pat.charAt(j) != txt.charAt(i + j))
                    break;

            if (j == m)
                System.out.print(i + " ");
        }
    }

    public static void patSearchinngDistinct(String txt, String pat) {
        // If pattern is completely distinct chars
        int m = pat.length();
        int n = txt.length();
        for (int i = 0; i <= (n - m);) {
            int j;
            for (j = 0; j < m; j++)
                if (pat.charAt(j) != txt.charAt(i + j))
                    break;

            if (j == m)
                System.out.print(i + " ");
            if (j == 0) {
                i++;
            } else { // Shifting the pattern search as the next j elem wont match
                i = (i + j);
            }
        }
    }

    public static void naivePatternSearching(String s, String p) {
        // My way
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return;
        }
        for (int i = 0; i <= n - m; i++) {
            String temp = s.substring(i, i + m);
            if (temp.equals(p)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        naivePatternSearching("abcd", "xyz");
    }
}
