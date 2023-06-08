package Arrays;

public class LeadersInArray {
    public static void leadersInArray(int[] arr) {
        int currMax = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= currMax) {
                System.out.print(arr[i] + " ");
                currMax = arr[i];
            }
        }

    }

    public static void main(String[] args) {
        leadersInArray(new int[] { 30, 20, 10 });
    }
}
