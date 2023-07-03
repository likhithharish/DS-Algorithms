package Strings;

public class PrintFrequency {
    // Given a string of lowercase char, print the frequency of unique chars in the
    // string in sorted order .

    public static void printFreq(String s) {
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                System.out.println((char) (i + 'a') + " " + chars[i]);
            }
        }
    }

    public static void main(String[] args) {
        printFreq("hello");
    }
}
