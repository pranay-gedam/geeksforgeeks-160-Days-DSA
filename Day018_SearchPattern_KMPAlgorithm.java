package gfg160Days_DSA;

import java.util.ArrayList;

public class Day018_SearchPattern_KMPAlgorithm {

    private int[] computeLPSArray(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int j = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to avoid unnecessary comparisons
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Main KMP search function
    public ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> indices = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        // Edge case: if pattern is longer than text, return empty list
        if (m > n) {
            return indices;
        }

        // Create the LPS array
        int[] lps = computeLPSArray(pat);
        int i = 0; // index for txt
        int j = 0; // index for pat

        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            // If we found a match
            if (j == m) {
                indices.add(i - j); // Add the starting index of the match
                j = lps[j - 1]; // Use LPS to find the next possible match
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to skip
                } else {
                    i++;
                }
            }
        }

        return indices; // Return the list of starting indices
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba", pat = "aaba";
        System.out.println();
    }
}
