package Sorting;

import java.util.Arrays;

public class MeetMaxGuests {
    /*
     * Given arrival and departure arrays, find the maximum number of guests
     * that can be met in the party at any timefram.
     * Guest time : arr[i], dept [i]
     */

    public static int maxMeets(int[] arr, int[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int currCount = 0;
        int res = 0;
        while (i < arr.length && j < arr.length) {
            if (arr[i] <= dep[j]) {
                i++;
                currCount += 1;
            } else if (arr[i] > dep[j]) {
                j++;
                currCount -= 1;
            }
            res = Math.max(currCount, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 800, 700, 600, 500 };
        int[] dep = { 840, 820, 830, 530 };
        System.out.println(maxMeets(arr, dep));
    }
}
