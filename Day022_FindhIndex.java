package gfg160Days_DSA;

import java.util.Arrays;

public class Day022_FindhIndex {

    // Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.
    //
    //H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

    public static int hIndex(int[] citations) {
        // Step 1: Sort the citations array in ascending order
        Arrays.sort(citations);

        // Step 2: Initialize the H-index variable
        int n = citations.length;
        int hIndex = 0;

        // Step 3: Find the H-index
        for (int i = 0; i < n; i++) {
            // Calculate the number of papers with at least (n - i) citations
            // n - i represents the number of papers from this point to the end of the array
            if (citations[i] >= (n - i)) {
                hIndex = n - i;  // Update the H-index
                break;
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        int [] citations = {5, 1, 2, 4, 1};
        System.out.println(hIndex(citations));
    }
}
