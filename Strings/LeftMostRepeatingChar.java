package Strings;

import java.util.Arrays;

public class LeftMostRepeatingChar {

    public static int leftMostRepeatChar(String s) {

        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static int efficientApproach1(String s) {
        int[] chars = new int[256];
        Arrays.fill(chars, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] == -1) {
                chars[s.charAt(i)] = i;
            } else {
                res = Math.min(res, chars[s.charAt(i)]);
            }
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static int efficientAppr2(String str) {
        boolean[] visited = new boolean[256];
        int res = -1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (visited[str.charAt(i)])
                res = i;
            else
                visited[str.charAt(i)] = true;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(leftMostRepeatChar("geeksforgeeks"));
        System.out.println(leftMostRepeatChar("abbcc"));
        System.out.println(leftMostRepeatChar("abcd"));

        System.out.println(efficientApproach1("geeksforgeeks"));
        System.out.println(efficientApproach1("abbcc"));
        System.out.println(efficientApproach1("abcd"));
    }
}
