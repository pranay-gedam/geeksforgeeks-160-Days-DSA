package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day024_OverlappingIntervals {

    public static List<int[]> mergeOverlap(int[][] arr) {
        // Edge case: if the input array is empty, return an empty list
        if (arr.length == 0) {
            return new ArrayList<>();
        }

        // Sort the intervals based on the start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = arr[0]; // Start with the first interval

        for (int i = 1; i < arr.length; i++) {
            // If the current interval overlaps with the next one
            if (arr[i][0] <= current[1]) {
                // Merge them by updating the end of the current interval
                current[1] = Math.max(current[1], arr[i][1]);
            } else {
                // If they don't overlap, add the current interval to the merged list
                merged.add(current);
                current = arr[i]; // Move to the next interval
            }
        }

        // Add the last interval
        merged.add(current);

        return merged; // Return the merged intervals
    }

    public static void main(String[] args) {
        Day024_OverlappingIntervals merger = new Day024_OverlappingIntervals();

        int arr[][] = {{1,3},{2,4},{6,8},{9,10}};
        List<int[]> mergedIntervals1 = merger.mergeOverlap(arr);
        System.out.println(mergedIntervals1);
    }
}
