package Arrays;

public class LargestElement {
    public static int largestElemIndex(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = (arr[i] > arr[res]) ? i : res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestElemIndex(new int[] { 10, 20, 100, 40 }));
    }
}
