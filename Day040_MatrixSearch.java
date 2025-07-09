package gfg160Days_DSA;


public class Day040_MatrixSearch {

    public static boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;      // number of rows
        int m = mat[0].length;   // number of columns

        int row = 0;      // start from the first row
        int col = m - 1;  // start from the last column

        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true;   // found x
            } else if (mat[row][col] > x) {
                col--;         // move left
            } else {
                row++;         // move down
            }
        }
        return false;          // x is not present in the matrix
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}
        };
        int x1 = 14;

        int[][] mat2 = {
                {1, 5, 9, 11},
                {14, 20, 21, 26},
                {30, 34, 43, 50}
        };
        int x2 = 42;

        System.out.println(searchMatrix(mat1, x1)); // Output: true
        System.out.println(searchMatrix(mat2, x2)); // Output: false
    }
}
