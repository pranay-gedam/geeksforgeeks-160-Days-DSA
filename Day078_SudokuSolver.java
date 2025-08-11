package gfg160Days_DSA;

public class Day078_SudokuSolver {

    static void solveSudoku(int[][] mat) {
        solve(mat);
    }

    private static boolean solve(int[][] mat) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) { // find empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(mat, row, col, num)) {
                            mat[row][col] = num;  // try number
                            if (solve(mat)) {
                                return true;
                            }
                            mat[row][col] = 0; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // solved
    }

    private static boolean isValid(int[][] mat, int row, int col, int num) {
        // Check row
        for (int c = 0; c < 9; c++) {
            if (mat[row][c] == num) return false;
        }
        // Check column
        for (int r = 0; r < 9; r++) {
            if (mat[r][col] == num) return false;
        }
        // Check 3x3 sub-grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = startRow; r < startRow + 3; r++) {
            for (int c = startCol; c < startCol + 3; c++) {
                if (mat[r][c] == num) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        Day078_SudokuSolver.solveSudoku(mat);

        // Print the solved Sudoku
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
