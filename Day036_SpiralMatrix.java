package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.List;

public class Day036_SpiralMatrix {

    public static ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0) {
            return result; // return empty if matrix is null or empty
        }

        int rows = mat.length;
        int cols = mat[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right on the topmost row
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;

            // Traverse from top to bottom on the rightmost column
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;

            // Check if there's still a bottom row to process
            if (top <= bottom) {
                // Traverse from right to left on the bottommost row
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }

            // Check if there's still a left column to process
            if (left <= right) {
                // Traverse from bottom to top on the leftmost column
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[][] mat2 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

//        int[] result1 = spirallyTraverse(mat1);
//        int[] result2 = spirallyTraverse(mat2);

//        System.out.println(java.util.Arrays.toString(result1));
//        System.out.println(java.util.Arrays.toString(result2));
    }
}
