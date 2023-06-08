package Arrays;

public class IsArraySorted {
    public static boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isArraySorted(new int[] { 1, 2, 3, 4 }));
        System.out.println(isArraySorted(new int[] { 1 }));
        System.out.println(isArraySorted(new int[] { 1, 1, 3, 4 }));
        System.out.println(isArraySorted(new int[] { 1, 2, 2, 2 }));
        System.out.println(isArraySorted(new int[] { 1, 2, 1, 2 }));
    }
}
