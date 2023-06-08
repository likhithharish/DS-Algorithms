package Arrays;

public class MaximumConsOne {
    // Given a binary array , compute maximum consecutive ones
    public static int consecutiveOnes(int[] arr) {
        if (arr.length <= 1) {
            return (arr[0] == 0) ? 0 : 1;
        }

        int res = 0;
        int currCount = (arr[0] == 0) ? 0 : 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == 1 && arr[i] == arr[i - 1]) {
                currCount += 1;
            } else if (arr[i - 1] == 0 && arr[i] == 1) {
                currCount = 1;
            }
            res = Math.max(res, currCount);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveOnes(new int[] { 0, 1, 1, 0, 1, 0 }));
        System.out.println(consecutiveOnes(new int[] { 1, 1, 1, 1 }));
        System.out.println(consecutiveOnes(new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 1 }));
        System.out.println(consecutiveOnes(new int[] { 1 }));
        System.out.println(consecutiveOnes(new int[] { 0, 0 }));
        System.out.println(consecutiveOnes(new int[] { 1, 1, 1, 0, 0, 1, 1, 1 }));

    }
}
