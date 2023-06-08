package Arrays;

public class MaximumDifference {
    public static int maximumDifference(int[] arr) {
        int currMin = arr[0];
        int res = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i] - currMin);
            currMin = Math.min(arr[i], currMin);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[] { 2, 3, 10, 6, 4, 8, 1 }));
        System.out.println(maximumDifference(new int[] { 7, 9, 5, 6, 3, 2 }));
        System.out.println(maximumDifference(new int[] { 10, 20, 30 }));
        System.out.println(maximumDifference(new int[] { 30, 10, 8, 2 }));
    }
}
