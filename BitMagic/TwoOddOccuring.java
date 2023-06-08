package BitMagic;

public class TwoOddOccuring {
    // Given an array find the two odd occuring elements
    // in the array

    public static void efficientSolution(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }

        int k = res & (~(res - 1));
        int res1 = 0, res2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & k) != 0) {
                res1 = res1 ^ nums[i];
            } else {
                res2 = res2 ^ nums[i];
            }
        }
        System.out.println(res1 + " , " + res2);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 3, 4, 5, 4, 4, 6, 7, 7 };
        efficientSolution(nums);
    }
}
