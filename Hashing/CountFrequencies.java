package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencies {
    // Given an array , print frequency of elements .

    public static void printFrequencies(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            System.out.print(e.getKey() + " " + e.getValue());
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        printFrequencies(new int[] { 10, 12, 10, 20, 30, 12, 10 });
    }
}
