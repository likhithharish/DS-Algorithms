package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctElem {
    // Given an array count distinct elem in the array
    public static int countDistinctElem(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.size();
    }

    public static int improvedImpl(Integer[] arr) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(countDistinctElem(new int[] { 15, 12, 13, 12, 13, 13, 18 }));
        System.out.println(improvedImpl(new Integer[] { 15, 12, 13, 12, 13, 13, 18 }));
    }
}
