package Matrix;

public class TransposeMatrix {
    // Convert the matrix to its transpose
    public static int[][] transposeMatrix(int[][] arr) {
        int[][] res = new int[arr[0].length][arr.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = arr[j][i];
            }
        }
        return res;
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

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        int[][] res = transposeMatrix(
                new int[][] { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } });
        printMatrix(res);
        res = transposeMatrix(
                new int[][] { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 }
                });
        printMatrix(res);
    }

}
