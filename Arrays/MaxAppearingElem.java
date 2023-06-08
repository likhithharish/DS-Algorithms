package Arrays;

import java.util.Arrays;

public class MaxAppearingElem {
    public static int maxAppearElem(int[] left, int[] right) {
        int[] freq = new int[101];
        Arrays.fill(freq, 0);
        for (int i = 0; i < left.length; i++) {
            freq[left[i]]++;
            freq[right[i] + 1]--; // +1 so 101 sized freq array
        }
        int res = 0;
        for (int i = 1; i < freq.length; i++) {
            freq[i] = freq[i - 1] + freq[i];
            if (freq[i] > freq[res]) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
