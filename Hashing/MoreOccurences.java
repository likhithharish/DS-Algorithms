package Hashing;

import java.util.*;

public class MoreOccurences {
    // Given a array and k, find the elem that occur more than n/k times.
    public static void printNByK(int arr[], int n, int k) {
        // Using sorting
        Arrays.sort(arr);
        int i = 1, count = 1;
        while (i < n) {
            while (i < n && arr[i] == arr[i - 1]) {
                count++;
                i++;
            }
            if (count > n / k)
                System.out.print(arr[i - 1] + " ");
            count = 1;
            i++;
        }

    }

    public static void printElem(int[] arr, int k) {
        // Using Hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int val = (int) Math.floor(arr.length / k);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > val) {
                System.out.print(e.getKey() + " ");
            }
        }

    }

    public static void printNByKEfficient(int arr[], int n, int k) {
        // Modified Moores algo
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            if (m.containsKey(arr[i])) {
                int count = m.get(arr[i]);
                m.put(arr[i], count + 1);
            } else if (m.size() < k - 1)
                m.put(arr[i], 1);
            else
                for (Map.Entry x : m.entrySet()) {
                    Integer c = (Integer) x.getValue();
                    m.put((Integer) x.getKey(), c - 1);
                    if ((Integer) x.getKey() == 0)
                        m.remove(x.getKey());
                }
        }
        for (Map.Entry x : m.entrySet()) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ((Integer) x.getKey() == arr[i])
                    count++;

            }
            if (count > n / k)
                System.out.print(x.getKey() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 30, 10, 20, 20, 10, 20, 30, 30 };
        printElem(arr, 4);
    }
}
