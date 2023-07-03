package Strings;

import java.util.Arrays;

public class LongestDistinctSubString {
    public static int longestDistinct(String s) {
        int n = s.length();
        int res = 0;
        int prev[] = new int[256];
        Arrays.fill(prev, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, prev[s.charAt(j)] + 1);
            int maxEnd = j - i + 1;
            res = Math.max(res, maxEnd);
            prev[s.charAt(j)] = j;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
