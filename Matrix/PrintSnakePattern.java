package Matrix;

public class PrintSnakePattern {
    // Given a 2d matrix , print matrix elements in a snake pattern.
    public static void printElemSnake(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            // current row is even
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {// Curr row is odd
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }

        }
    }

    public static void main(String[] args) {
        printElemSnake(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } });
    }
}
