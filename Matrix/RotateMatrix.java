package Matrix;

public class RotateMatrix {
    // Rotate a n*n matrix by 90 (clockwise & anticlockwise) - two methods
    // ANTI CLOCKWISE - 90
    public static int[][] roatateMatrixAnti(int[][] matrix) {
        // Using extra space
        int[][] res = new int[matrix.length][matrix[0].length];
        int start = 0, end = matrix[0].length - 1;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = matrix[start][end];
                start++;
            }
            start = 0;
            end--;
        }
        return res;
    }

    // Anti clockwise Efficient - Transpose + reverse co{lumns
    public static int[][] rotateAntiEff(int[][] matrix) {
        matrix = transposeInPlace(matrix);
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            for (int i = 0; i < matrix[0].length; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
            start++;
            end--;
        }
        return matrix;
    }

    public static int[][] transposeInPlace(int[][] arr) {
        // Transpose inplace for a square matrix n *n
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            int end = arr[i].length;
            for (int j = start; j < end; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
            start++;
        }
        return arr;
    }

    // CLOCKWISE - 90

    public static int[][] rotateMatrixClock(int[][] matrix) {
        // Roatate using extra space 90 clockwise
        int[][] res = new int[matrix.length][matrix[0].length];
        int start = matrix.length - 1, end = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = matrix[start][end];
                start--;
            }
            start = matrix.length - 1;
            end++;
        }
        return res;
    }

    public static int[][] rotateClockEff(int[][] matrix) {
        // Reverse,
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            for (int i = 0; i < matrix[0].length; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;
            }
            start++;
            end--;
        }
        // Transpose
        matrix = transposeInPlace(matrix);
        return matrix;
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[][] res = roatateMatrixAnti(
                new int[][] { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } });
        printMatrix(res);
        res = rotateAntiEff(
                new int[][] { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } });
        printMatrix(res);
        res = roatateMatrixAnti(new int[][] { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } });
        printMatrix(res);
        res = rotateMatrixClock(new int[][] { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } });
        printMatrix(res);

    }
}
