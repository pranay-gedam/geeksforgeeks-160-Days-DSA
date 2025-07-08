package gfg160Days_DSA;

public class Day038_MatrixSearch {
    public static boolean searchMatrix(int[][] mat, int x) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return false;
        }

        int n = mat.length;
        int m = mat[0].length;

        // Start from the top-right corner
        int row = 0;
        int col = m - 1;

        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true; // Found the element
            } else if (mat[row][col] > x) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        // Element not found
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {
                {3, 30, 38},
                {20, 52, 54},
                {35, 60, 69}
        };
        int x1 = 62;
        System.out.println(searchMatrix(matrix1, x1)); // Output: false

        int[][] matrix2 = {
                {18, 21, 27},
                {38, 55, 67}
        };
        int x2 = 55;
        System.out.println(searchMatrix(matrix2, x2)); // Output: true

        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int x3 = 3;
        System.out.println(searchMatrix(matrix3, x3)); // Output: true
    }
}
