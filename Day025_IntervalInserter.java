package gfg160Days_DSA;

import java.util.ArrayList;

public class Day025_IntervalInserter {

    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();

        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add the remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
        int[] newInterval1 = {5, 6};
        System.out.println(insertInterval(intervals1, newInterval1)); // Output: [[1,3], [4,7], [8,10]]

        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 9};
        System.out.println(insertInterval(intervals2, newInterval2)); // Output: [[1,2], [3,10], [12,16]]
    }
}
