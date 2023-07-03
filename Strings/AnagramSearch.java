package Strings;

public class AnagramSearch {
    static final int CHAR = 256;

    static boolean areAnagram(String pat, String txt, int i) {
        int[] count = new int[CHAR];
        for (int j = 0; j < pat.length(); j++) {
            count[pat.charAt(j)]++;
            count[txt.charAt(i + j)]--;
        }
        for (int j = 0; j < CHAR; j++) {
            if (count[j] != 0)
                return false;
        }
        return true;
    }

    // Naive Solution
    static boolean isPresent(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();
        for (int i = 0; i <= n - m; i++) {
            if (areAnagram(pat, txt, i))
                return true;
        }
        return false;
    }

    public static boolean efficient(String txt, String pat) {
        int[] ct = new int[256];
        int[] pt = new int[256];
        for (int i = 0; i < pat.length(); i++) {
            ct[txt.charAt(i)]++;
            pt[pat.charAt(i)]++;
        }

        for (int i = pat.length(); i < txt.length(); i++) {
            if (areSame(ct, pt)) {
                return true;
            }
            ct[txt.charAt(i)]++;
            ct[txt.charAt(i - pat.length())]--;
        }
        return false;
    }

    public static boolean areSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(efficient("geeksforgeeks", "reeks"));
    }
}
