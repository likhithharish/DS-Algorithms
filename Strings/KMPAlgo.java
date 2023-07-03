package Strings;

import java.util.Arrays;

public class KMPAlgo {
    // KMP Algorithm for Pattern Searching

    // Fill LPS Array Naive
    public static void fillLPS(String str, int[] lps) {
        for (int i = 0; i < str.length(); i++) {
            lps[i] = longPropPreSuff(str, i + 1);
        }
    }

    public static int longPropPreSuff(String str, int n) {
        for (int len = n - 1; len > 0; len--) {
            boolean flag = true;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != str.charAt(n - len + i)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                return len;
            }
        }
        return 0;
    }

    // Efficient fill LPS Array
    public static void efffillLPS(String str, int lps[]) {
        int n = str.length(), len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
    }

    public static void KMP(String pat, String txt) {
        int N = txt.length();
        int M = pat.length();
        int[] lps = new int[M];
        efffillLPS(pat, lps);
        int i = 0, j = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                System.out.println("Found pattern at index: " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j == 0)
                    i++;
                else
                    j = lps[j - 1];
            }
        }
    }

    public static void main(String[] args) {
        String s = "ababab";
        int[] arr = new int[s.length()];
        efffillLPS(s, arr);
        System.out.println(Arrays.toString(arr));
        KMP("abcd", "abcdeabc");
    }
}
