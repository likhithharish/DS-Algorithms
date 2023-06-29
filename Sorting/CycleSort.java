package Sorting;

import java.util.Arrays;

public class CycleSort {

    public static int[] cycleSortDistinct(int[] arr) {
        for (int cs = 0; cs < arr.length - 1; cs++) {// cs- cyclestart
            // cs goes till n-2 only, since n-1 either gets fixed as part of cycle
            // or already the largest elem
            int item = arr[cs];
            int pos = cs;
            for (int i = cs + 1; i < arr.length; i++) {
                if (arr[i] < item) {
                    pos++;
                }
            }
            // swap(item, arr[pos]);
            int temp = arr[pos];
            arr[pos] = item;
            item = temp;

            // complete the cycle
            while (pos != cs) {// for corrected values this wont run
                pos = cs;
                for (int i = cs + 1; i < arr.length; i++) {
                    if (arr[i] < item) {
                        pos++;
                    }
                }
                int newTemp = arr[pos];
                arr[pos] = item;
                item = newTemp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(cycleSortDistinct(new int[] { 20, 30, 10, 40, 50 })));
    }
}
