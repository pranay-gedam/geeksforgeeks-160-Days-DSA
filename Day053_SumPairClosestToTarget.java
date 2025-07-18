package gfg160Days_DSA;

import java.util.*;

public class Day053_SumPairClosestToTarget {

    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return result; // no valid pair
        }

        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = -1;
        int resA = 0, resB = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(sum - target);
            int absDiff = Math.abs(arr[left] - arr[right]);

            // Check if this pair is better
            if (diff < closestDiff || (diff == closestDiff && absDiff > maxAbsDiff)) {
                closestDiff = diff;
                maxAbsDiff = absDiff;
                resA = arr[left];
                resB = arr[right];
            }

            // Move pointers accordingly
            if (sum == target) {
                // Exact match, already optimal
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // Add the result pair
        result.add(resA);
        result.add(resB);
        return result;
    }

    public static void main(String[] args) {
        Day053_SumPairClosestToTarget solution = new Day053_SumPairClosestToTarget();

        // Test case 1
        int[] arr1 = {10, 30, 20, 5};
        int target1 = 25;
        System.out.println("Result: " + solution.sumClosest(arr1, target1));  // [5, 20]

        // Test case 2
        int[] arr2 = {5, 2, 7, 1, 4};
        int target2 = 10;
        System.out.println("Result: " + solution.sumClosest(arr2, target2));  // [2, 7]
    }
}
