package Strings;

import java.util.Arrays;

public class LexiographicRank {
    // Given a string , find the lexiographic rank of the string across all its
    // permutations
    public static int rankOfString(String s) {
        int f = fact(s.length());
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        // Cummulative
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            f = f / (s.length() - i);
            res += (count[s.charAt(i)] - 1) * (f);

            for (int j = s.charAt(i); j < 256; j++) {
                count[j]--;// decrement count array on its right
            }
        }
        return res;
    }

    public static int fact(int n) {
        int res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(rankOfString("DCBA"));
    }

}
