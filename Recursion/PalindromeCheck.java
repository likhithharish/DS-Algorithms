package Recursion;

public class PalindromeCheck {

    public static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        return (s.charAt(start) == s.charAt(end)) && isPalindrome(s, start + 1, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abbc", 0, "abba".length() - 1));
    }
}
