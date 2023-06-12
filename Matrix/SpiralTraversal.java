package Matrix;

import java.util.*;

public class SpiralTraversal {
    // Given a 2d matrix perform 2d traversal and print the elem.

    public static List<Integer> spiralTraversal(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {// avoid duplicates addition
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {// avoid duplicate addition
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = spiralTraversal(
                new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
        System.out.println(res);
    }
}
