package Queue_DSA;

import java.util.*;

public class GenerateNumbers {
    // Generate numbers that contains only given digits - (5,6) here
    public static void generateNumbers(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("5");
        q.add("6");
        int count = 0;
        while (!q.isEmpty() && count < n) {
            String val = q.remove();
            System.out.print(val + " ");
            count++;
            String val1 = val + "5";
            q.add(val1);
            String val2 = val + "6";
            q.add(val2);
        }
    }

    public static void main(String[] args) {
        generateNumbers(10);
    }
}
