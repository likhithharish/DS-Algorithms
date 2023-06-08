package Arrays;

public class ConsecutiveFlips {
    public static int minFlips(int[] nums) {
        int consOne = 0;
        int consZero = 0;
        if (nums[0] == 1) {
            consOne = 1;
        } else {
            consZero = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {

                if (nums[i] == 0) {
                    consZero++;
                } else {
                    consOne++;
                }
            }
        }
        return Math.min(consOne, consZero);
    }

    public static void printFlips(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] != nums[0]) {
                    System.out.print("From " + i + " ");
                } else {
                    System.out.print("to " + (i - 1));
                }
            }
        }
        if (nums[nums.length - 1] != nums[0]) {
            System.out.print("to " + (nums.length - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(minFlips(new int[] { 1, 0, 0, 1, 1, 1 }));
        printFlips(new int[] { 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1 });
        // System.out.println(minFlips(new int[] { 0, 1, 1, 0, 0, 0 }));
        // System.out.println(minFlips(new int[] { 1, 1, 0, 0, 0, 1 }));
        // System.out.println(minFlips(new int[] { 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1 }));
        // System.out.println(minFlips(new int[] { 1, 1, 1 }));
        // System.out.println(minFlips(new int[] { 0, 0, 0 }));

    }
}
