package Arrays;

public class ReverseanArray {
    public static int[] reverseArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res = reverseArray(new int[] { 1, 2, 3 });
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
