package gfg160Days_DSA;

import java.util.ArrayList;

public class Day077_NQueenProblem {

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        int[] positions = new int[n]; // positions[col] = row index (1-based)
        backtrack(results, positions, 0, n);
        return results;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> results, int[] positions, int col, int n) {
        if (col == n) {
            // Found a valid solution, convert to 1-based and add
            ArrayList<Integer> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                solution.add(positions[i]);
            }
            results.add(solution);
            return;
        }
        for (int row = 1; row <= n; row++) {
            if (isSafe(positions, col, row)) {
                positions[col] = row;
                backtrack(results, positions, col + 1, n);
            }
        }
    }

    private boolean isSafe(int[] positions, int col, int row) {
        for (int i = 0; i < col; i++) {
            // Check for diagonal conflicts
            if (positions[i] == row || Math.abs(positions[i] - row) == Math.abs(i - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Day077_NQueenProblem solution = new Day077_NQueenProblem();

        int n = 4; // Change this value to test different sizes
        ArrayList<ArrayList<Integer>> results = solution.nQueen(n);

        System.out.println("Total solutions for n = " + n + ": " + results.size());
        for (ArrayList<Integer> res : results) {
            System.out.println(res);
        }
    }
}
