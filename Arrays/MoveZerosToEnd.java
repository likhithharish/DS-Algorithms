package Arrays;

public class MoveZerosToEnd {

    public static int[] naiveSolution(int[] arr) {
        // No extra space - more complex
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        arr = swap(arr, i, j);
                        break;
                    }
                }
            }
        }
        return arr;
    }

    public static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static int[] moveZerosToEnd(int[] arr) {
        // using extra space
        int[] temp = new int[arr.length];
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp[i - res] = arr[i];
            } else {
                res++;
            }
        }
        return temp;
    }

    public static int[] efficientSolution(int[] arr) {
        // No extra space and O(n)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr = swap(arr, i, count);
                count++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ans = efficientSolution(new int[] { 10, 20, 0, 20, 0, 0, 10 });
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
