package Strings;

import java.util.Arrays;

public class LeftMostNonRepeat {

    public static int leftMostNonRepeatChar(String s) {

        int[] chars = new int[256];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int efficientApproach1(String s) {
        int[] chars = new int[256];
        Arrays.fill(chars, -1);
        int res = Integer.MAX_VALUE;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (chars[s.charAt(i)] == -1) {
                chars[s.charAt(i)] = i;
            } else {
                chars[s.charAt(i)] = -2;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 0) {
                res = Math.min(res, chars[i]);
            }
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(leftMostNonRepeatChar("geeksforgeeks"));

        System.out.println(efficientApproach1("aabcc"));
        System.out.println(efficientApproach1("geeksforgeeks"));
        System.out.println(efficientApproach1("abcd"));
    }
}
