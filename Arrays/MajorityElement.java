package Arrays;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        // Majority element exists for sure in array
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }

    public static int majorityElementExtend(int[] nums) {
        // Majority element may/maynot exist in the array
        // Find the majority elem check if it is majority
        // Phase 1 - finding majority
        int res = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[res] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = i;
                count = 1;
            }
        }

        // Confirming majority
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[res] == nums[i]) {
                count++;
            }
        }
        if (count <= nums.length / 2) {
            res = -1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
