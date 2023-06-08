package Mathematics;

public class PalindromeNumber {
    // Find out if given number is palindrome number or not ,
    // same from both ends
    public static boolean isPalindrome(int n) {
        String val = String.valueOf(n);
        int low = 0, high = val.length() - 1;
        while (low <= high) {
            if (val.charAt(low) != val.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static boolean isPalindromeSecond(int n) {
        // without using string
        int rev = 0;
        int comp = n;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n = n / 10;
        }
        return (rev == comp);
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeSecond(10));
    }
}
