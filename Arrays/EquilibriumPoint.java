package Arrays;

public class EquilibriumPoint {
    public static boolean eqPoint(int[] arr) {
        int n = arr.length;
        int[] lSum = new int[arr.length];
        lSum[0] = arr[0];
        int[] rSum = new int[arr.length];
        rSum[n - 1] = arr[n - 1];
        for (int i = 1; i < arr.length; i++) {
            lSum[i] = lSum[i - 1] + arr[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            rSum[i] = rSum[i + 1] + arr[i];
        }

        for (int i = 0; i < lSum.length; i++) {
            if (lSum[i] == rSum[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean eqPointModified(int[] arr) {
        // Only one left SUm array
        int n = arr.length;
        int[] lSum = new int[arr.length];
        lSum[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lSum[i] = lSum[i - 1] + arr[i];
        }
        int rightSum = arr[n - 1];
        if (lSum[n - 1] == rightSum) {
            return true;
        }
        for (int i = n - 2; i >= 0; i--) {
            rightSum += arr[i];
            if (rightSum == lSum[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean eqPointMORE(int[] arr) {
        int n = arr.length;
        int rSum = 0;
        for (int i = 0; i < n; i++) {
            rSum += arr[i];
        }
        int lSum = 0;
        for (int i = 0; i < n; i++) {
            rSum -= arr[i];
            if (lSum == rSum) {
                return true;
            }
            lSum += arr[i];
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(eqPoint(new int[] { 4, 2, 2 }));
        System.out.println(eqPointModified(new int[] { 2, -2, 1 }));
        System.out.println(eqPointMORE(new int[] { 4, 2, -2 }));
    }
}
