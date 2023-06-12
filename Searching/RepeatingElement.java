package Searching;

public class RepeatingElement {
    // FInd the repeating element in array

    public static int efficientApproach(int[] nums) {
        int[] temp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static int moreEfficientApproach(int[] nums) {
        // Elements start with 1.
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static int finalSOlution(int[] nums) {
        // Elements start with 0.
        int slow = nums[0] + 1, fast = nums[0] + 1;
        do {
            slow = nums[slow] + 1;
            fast = nums[nums[fast] + 1] + 1;
        } while (slow != fast);
        slow = nums[0] + 1;
        while (slow != fast) {
            slow = nums[slow] + 1;
            fast = nums[fast] + 1;
        }
        return slow - 1;
    }

    public static void main(String[] args) {

    }
}
