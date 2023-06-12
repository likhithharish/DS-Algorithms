package Matrix;

public class PrintBoundaryElem {
    // Print boundary elements of matrix
    public static void printBoundaries(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else if (i == arr.length - 1) {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                System.out.print(arr[i][arr[i].length - 1] + " ");
            }
        }
        if (arr[0].length > 1) {
            for (int i = arr.length - 2; i > 0; i--) {
                System.out.print(arr[i][0] + " ");
            }
        }

        System.out.println("");
        System.out.println("------");
    }

    public static void polishedCode(int[][] arr) {
        if (arr.length == 1) {
            for (int i = 0; i < arr[0].length; i++)
                System.out.print(arr[0][i] + " ");
        } else if (arr[0].length == 1) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i][0] + " ");
        } else {
            for (int i = 0; i < arr[0].length; i++)
                System.out.print(arr[0][i] + " ");
            for (int i = 1; i < arr.length; i++)
                System.out.print(arr[i][arr[0].length - 1] + " ");
            for (int i = arr[0].length - 2; i >= 0; i--)
                System.out.print(arr[arr.length - 1][i] + " ");
            for (int i = arr.length - 2; i >= 1; i--)
                System.out.print(arr[i][0] + " ");
        }
    }

    public static void main(String[] args) {
        printBoundaries(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } });
        printBoundaries(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
        printBoundaries(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } });
        printBoundaries(new int[][] { { 1, 2, 3, 4 } });
        printBoundaries(new int[][] { { 1 }, { 2 }, { 3 } });
        polishedCode(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } });
    }
}
