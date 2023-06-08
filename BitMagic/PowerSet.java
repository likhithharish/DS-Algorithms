package BitMagic;

public class PowerSet {

    public static void powerSets(String s) {
        int n = s.length();
        int pSize = (1 << n); // this is same as 2 power n - total subsets of string
        for (int i = 0; i < pSize; i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        powerSets("ab");
    }
}
