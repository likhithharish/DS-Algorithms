package Arrays;

public class LeftRotateArrbyOne {

    public static int[] leftRotateByOne(int[] arr) {
        int firstElem = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = firstElem;
        return arr;
    }

    public static void main(String[] args) {
        int[] res = leftRotateByOne(new int[] { 1, 2, 3, 4, 5 });
        for (int i : res) {
            System.out.print(i + " ");
        } // 2 3 4 5 1
    }
}
