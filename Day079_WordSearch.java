package gfg160Days_DSA;

public class Day079_WordSearch {

    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];

        // Loop through each cell to find starting points
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(mat, word, 0, i, j, visited)) {
                    return true; // Found a match
                }
            }
        }
        return false; // No match found
    }

    private static boolean dfs(char[][] mat, String word, int index, int i, int j, boolean[][] visited) {
        // Check boundary conditions and character match
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || visited[i][j] || mat[i][j] != word.charAt(index)) {
            return false;
        }

        // Check if all characters are matched
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        visited[i][j] = true;

        // Explore all 4 directions
        boolean found = dfs(mat, word, index + 1, i + 1, j, visited) ||
                dfs(mat, word, index + 1, i - 1, j, visited) ||
                dfs(mat, word, index + 1, i, j + 1, visited) ||
                dfs(mat, word, index + 1, i, j - 1, visited);

        // Backtrack
        visited[i][j] = false;
        return found;
    }

    public static void main(String[] args) {
        char[][] mat1 = {
                {'T', 'E', 'E'},
                {'S', 'G', 'K'},
                {'T', 'E', 'L'}
        };
        String word1 = "GEEK";

        System.out.println(Day079_WordSearch.isWordExist(mat1, word1));  // Output: true

        char[][] mat2 = {
                {'T', 'E', 'U'},
                {'S', 'G', 'K'},
                {'T', 'E', 'L'}
        };
        String word2 = "GEEK";

        System.out.println(Day079_WordSearch.isWordExist(mat2, word2));  // Output: false

        char[][] mat3 = {
                {'A', 'B', 'A'},
                {'B', 'A', 'B'}
        };
        String word3 = "AB";

        System.out.println(Day079_WordSearch.isWordExist(mat3, word3));  // Output: true
    }
}
