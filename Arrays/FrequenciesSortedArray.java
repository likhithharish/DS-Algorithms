package Arrays;

public class FrequenciesSortedArray {
    public static void printFrequencies(int[] arr) {
        if (arr.length == 1) {
            System.out.println(arr[0] + " : " + 1);
        }
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                System.out.println(arr[i - 1] + " : " + count);
                count = 1;
            }
            if (i == arr.length - 1) {
                System.out.println(arr[i] + " : " + count);
            }
        }
    }

    public static void main(String[] args) {
        printFrequencies(new int[] { 10 });
    }
}
