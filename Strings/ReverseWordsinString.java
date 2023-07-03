package Strings;

public class ReverseWordsinString {
    public static String reverseWords(String s) {
        String[] vals = s.split(" ");
        int low = 0, high = vals.length - 1;
        while (low <= high) {
            String temp = vals[low];
            vals[low] = vals[high];
            vals[high] = temp;
            low++;
            high--;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < vals.length - 1; i++) {
            str.append(vals[i] + " ");
        }
        str.append(vals[vals.length - 1]);
        return str.toString();
    }

    public static void efficientWay(char[] str) {
        int start = 0;
        for (int end = 0; end < str.length; end++) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
        reverse(str, start, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    public static void reverse(char[] str, int i, int j) {
        while (i <= j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "World is Beautiful";
        char[] ch = s.toCharArray();
        efficientWay(ch);
        System.out.println(ch); // Op: Beautiful is World
    }
}
