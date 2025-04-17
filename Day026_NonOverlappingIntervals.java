package gfg160Days_DSA;

import java.util.Arrays;
import java.util.Comparator;

public class Day026_NonOverlappingIntervals {

    public static int minRemoval(int[][] intervals) {
        // If there are no intervals, return 0
        if (intervals.length == 0) return 0;

        // Sort intervals based on the end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // Initialize variables
        int removalCount = 0;
        int lastEnd = intervals[0][1];

        // Iterate through sorted intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            // Check if the current interval overlaps with the last non-overlapping interval
            if (intervals[i][0] < lastEnd) {
                // If it overlaps, increment the removal counter
                removalCount++;
            } else {
                // If it doesn't overlap, update the last end to the current end
                lastEnd = intervals[i][1];
            }
        }

        return removalCount;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(minRemoval(intervals1));
    }
}
