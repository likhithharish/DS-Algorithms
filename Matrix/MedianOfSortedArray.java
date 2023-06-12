package Matrix;

import java.util.Arrays;

public class MedianOfSortedArray {
    // Matrix is row-wise sorted , nd all distinct elements in matrix, odd num of
    // elements in matrix.
    public static int median(int[][] matrix) {
        int c = matrix[0].length;
        int r = matrix.length;
        int max = matrix[0][c - 1], min = matrix[0][0];
        for (int i = 0; i < r; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][c - 1]);
        }
        int medianPos = ((r * c) + 1) / 2;
        while (min < max) {
            int midVal = (min + max) / 2;
            int midPos = 0;
            for (int i = 0; i < r; i++) {
                int pos = Arrays.binarySearch(matrix[i], midVal) + 1;
                midPos += Math.abs(pos);
            }

            if (midPos < medianPos) {
                min = midVal + 1;
            } else {
                max = midVal;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(median(new int[][] { { 1, 10, 20 }, { 15, 25, 35 }, { 5, 30, 40 } }));
        System.out.println(median(new int[][] { { 2, 4, 6, 8, 10 }, { 1, 3, 5, 7, 9 }, { 100, 200, 300, 400, 500 } }));

    }
}
