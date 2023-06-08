package BitMagic;

public class OneOddOccuring {
    // Find the only odd occuring number in a given array

    // Naive solution is count each number and if it is
    // odd we return it. O(n2)

    public static int efficientSolution(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 3, 1, 4, 4, 4, 5, 5 };
        System.out.println(efficientSolution(nums));
    }
}
