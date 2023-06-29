package Sorting;

public class IntersectionTwoSortedArr {
    // given two sorted arrays, find the common elements
    public static void intersectionOfArrays(int[] a, int[] b) {

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (a[i] < b[j]) {
                i++;
            } else if (b[j] < a[i]) {
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] a = { 3, 5, 19, 19, 19, 20, 30 };
        int[] b = { 5, 19, 19, 20, 40 };
        intersectionOfArrays(a, b);
    }
}
