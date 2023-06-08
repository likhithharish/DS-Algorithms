package Mathematics;

public class LCMofNumbers {
    // Find LCM of two given numbers

    public static int naiveLCMSolution(int a, int b) {
        int res = Math.max(a, b);
        // since lcm can be either max of a,b
        // or greater than max element

        while (true) {
            if (res % a == 0 && res % b == 0) {
                return res;
            }
            res++;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int efficientLCM(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        System.out.println(efficientLCM(12, 15));
    }
}
