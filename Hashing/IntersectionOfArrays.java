package Hashing;

import java.util.*;

public class IntersectionOfArrays {
    // Given two arrays, print the intersecting elements.

    public static void printIntersection(int[] arr, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int i : arr) {
            if (set.contains(i)) {
                System.out.print(i + " ");
                set.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 10, 10, 20, 30, 40 };
        int[] nums = { 10, 10, 20, 30 };
        printIntersection(arr, nums);
    }
}
