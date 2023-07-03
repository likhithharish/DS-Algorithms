package Strings;

public class CheckIsAnagram {
    public static boolean isAnagram(String s1, String s2) {
        // assuming all lowercase alphabets in s1 and s2.
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] chars = new int[256];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)]++;
            chars[s2.charAt(i)]--;
        }

        for (int i : chars) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("listeg", "silent"));
    }
}
