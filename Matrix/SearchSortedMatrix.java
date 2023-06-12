package Matrix;

public class SearchSortedMatrix {
    public static int[] searchSortedMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int end = matrix[i].length - 1;
            int start = 0;
            if (target >= matrix[i][start] && target <= matrix[i][end]) {
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (matrix[i][mid] == target) {
                        return new int[] { i, mid };
                    }
                    if (matrix[i][mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return new int[0];
    }

    // O(R+C)
    public static int[] efficientSolution(int[][] matrix, int target) {
        int bottom = 0, left = matrix[0].length - 1;
        System.out.println(matrix[left][bottom]);
        while (left >= 0 && bottom < matrix.length) {
            if (matrix[bottom][left] == target) {
                return new int[] { left, bottom };
            } else if (matrix[bottom][left] > target) {
                left--;
            } else {
                bottom++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int[] res = efficientSolution(matrix, 2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
