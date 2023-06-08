package Arrays;

public class SubArrwithGivenSum {
    public static boolean subArrayWithSum(int[] nums, int k) {
        int sum = 0;
        int low = 0;
        for (int high = 0; high < nums.length; high++) {
            sum += nums[high];
            while (k < sum) {
                sum -= nums[low];
                low++;
            }
            if (sum == k) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(subArrayWithSum(new int[] { -1, -1, 1 }, 0));
    }
}
