package gfg160Days_DSA;

public class Day039_RowMatrixSearch {

    // Function to search a given number in a row-column sorted matrix.
    public static boolean searchRowMatrix(int[][] mat, int x) {
        int rows = mat.length;
        if (rows == 0) return false; // Handle empty matrix
        int columns = mat[0].length;

        // Start from the top-right corner of the matrix
        int i = 0, j = columns - 1;

        // Iterate while within matrix bounds
        while (i < rows && j >= 0) {
            if (mat[i][j] == x) {
                return true; // Element found
            } else if (mat[i][j] > x) {
                j--; // Move left
            } else {
                i++; // Move down
            }
        }
        return false; // Element not found
    }

    public static void main(String[] args) {
        int[][] mat1 = {{3, 4, 9}, {2, 5, 6}, {9, 25, 27}};
        int target1 = 9;

        int[][] mat2 = {{19, 22, 27, 38, 55, 67}};
        int target2 = 56;

        System.out.println(Day039_RowMatrixSearch.searchRowMatrix(mat1, target1)); // Output: true
        System.out.println(Day039_RowMatrixSearch.searchRowMatrix(mat2, target2)); // Output: false
    }
}
