package Arrays;

public class SecondLargestElem {
    public static int secondLargestElem(int[] arr) {
        int first = 0;
        int second = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[first]) {
                second = first;
                first = i;
            } else if (arr[i] != arr[first]) {
                if (second == -1 || arr[i] > arr[second]) {
                    second = i;
                }
            }
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(secondLargestElem(new int[] { 10, 10, 10, 20 }));
    }
}
