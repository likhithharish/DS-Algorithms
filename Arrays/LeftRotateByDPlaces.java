package Arrays;

public class LeftRotateByDPlaces {
    // Left rotate an array by d places
    public static int[] leftRotateByD(int[] arr, int d) {
        // using extra space
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int i = d; i < arr.length; i++) {
            arr[i - d] = arr[i];
        }
        int k = 0;
        for (int i = arr.length - d; i < arr.length; i++) {
            arr[i] = temp[k];
            k++;
        } // THis loop can be simplified like below
          // for (int i = 0; i < d; i++) {
          // arr[arr.length - d + i] = temp[i];
          // }
        return arr;
    }

    public static int[] optimisedSolution(int[] arr, int d) {
        reverse(arr, 0, d - 1);
        reverse(arr, d, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        return arr;
    }

    public static int[] reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            high--;
            low++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] res = optimisedSolution(new int[] { 1, 2, 3, 4, 5 }, 3);
        for (int i : res) {
            System.out.print(i + ", ");
        } // 3, 4, 5, 1, 2
    }
}
