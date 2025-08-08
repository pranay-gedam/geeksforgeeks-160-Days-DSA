package gfg160Days_DSA;

import java.util.*;

public class Day075_FindPermutation {

    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[chars.length];
        StringBuilder currentPermutation = new StringBuilder();
        backtrack(chars, used, currentPermutation, result);
        return result;
    }

    private void backtrack(char[] chars, boolean[] used, StringBuilder current, ArrayList<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // Skip used characters
            if (used[i]) continue;

            // Skip duplicate characters unless the previous duplicate has been used
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.append(chars[i]);
            backtrack(chars, used, current, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Day075_FindPermutation solution = new Day075_FindPermutation();

        // Test case 1
        String s1 = "ABC";
        System.out.println("Permutations of " + s1 + ": " + solution.findPermutation(s1));

        // Test case 2
        String s2 = "ABSG";
        System.out.println("Permutations of " + s2 + ": " + solution.findPermutation(s2));

        // Test case 3
        String s3 = "AAA";
        System.out.println("Permutations of " + s3 + ": " + solution.findPermutation(s3));
    }
}
