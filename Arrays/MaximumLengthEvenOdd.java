package Arrays;

public class MaximumLengthEvenOdd {
    public static int maxLengthevenOdd(int[] arr) {
        int count = 1;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i - 1] % 2 == 0 && arr[i] % 2 != 0) ||
                    (arr[i - 1] % 2 != 0 && arr[i] % 2 == 0)) {
                count += 1;
                res = Math.max(count, res);
            } else {
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthevenOdd(new int[] { 10, 12, 14, 7, 8 }));
        System.out.println(maxLengthevenOdd(new int[] { 7, 10, 13, 14 }));
        System.out.println(maxLengthevenOdd(new int[] { 10, 12, 8, 4 }));
        System.out.println(maxLengthevenOdd(new int[] { 1 }));
        System.out.println(maxLengthevenOdd(new int[] { 2 }));
    }
}
