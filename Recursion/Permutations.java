package Recursion;

public class Permutations {
    public static void permutations(String s, int i) {
        if (i == s.length() - 1) {
            System.out.print(s + " ");
            return;
        }
        for (int j = i; j < s.length(); j++) {
            s = swap(s, i, j);
            permutations(s, i + 1);
            s = swap(s, j, i);
        }
    }

    public static String swap(String str, int i, int j) {
        char temp;
        char[] strArr = str.toCharArray();
        temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;
        return String.valueOf(strArr);
    }

    public static void main(String[] args) {
        permutations("ABC", 2);
    }
}
