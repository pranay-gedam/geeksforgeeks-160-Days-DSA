package gfg160Days_DSA;


public class Day041_ZeroMatrix {

    public static void setZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row has zero
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first column has zero
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and column as markers
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0; // Mark row i
                    mat[0][j] = 0; // Mark column j
                }
            }
        }

        // Zero out cells based on markers for rows
        for (int i = 1; i < n; i++) {
            if (mat[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    mat[i][j] = 0;
                }
            }
        }

        // Zero out cells based on markers for columns
        for (int j = 1; j < m; j++) {
            if (mat[0][j] == 0) {
                for (int i = 0; i < n; i++) {
                    mat[i][j] = 0;
                }
            }
        }

        // Zero out the first row if needed
        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        // Zero out the first column if needed
        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }

    // Utility method to print the matrix
    public static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, -1, 1},
                {-1, 0, 1},
                {1, -1, 1}
        };

        int[][] mat2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        System.out.println("Original matrix 1:");
        printMatrix(mat1);
        setZeroes(mat1);
        System.out.println("Modified matrix 1:");
        printMatrix(mat1);

        System.out.println("\nOriginal matrix 2:");
        printMatrix(mat2);
        setZeroes(mat2);
        System.out.println("Modified matrix 2:");
        printMatrix(mat2);
    }
}
