package Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr, int size) {
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] { 10, 20, 20, 30, 30, 30, 30 }, 7));
        System.out.println(removeDuplicates(new int[] { 10, 10, 10 }, 3));
        System.out.println(removeDuplicates(new int[] { 10 }, 1));
        System.out.println(removeDuplicates(new int[] { 10, 20, 30, 40, 40, 40 }, 6));
    }
}
