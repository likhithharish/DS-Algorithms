package Sorting;

public class UnionTwoSortArr {
    // print union of two sorted arrays in sorted order and each element only once.
    public static void union(int[] a, int[] b) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else if (b[j] < a[i]) {
                System.out.print(b[j] + " ");
                j++;
            } else {
                System.out.print(a[i] + " ");
                i++;
                j++;
            }
        }
        while (i < a.length) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            System.out.print(a[i] + " ");
            i++;
        }
        while (j < b.length) {
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            System.out.print(b[j] + " ");
            j++;
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 2, 4, 4 };
        int[] b = { 2, 5 };
        union(a, b);
    }
}
