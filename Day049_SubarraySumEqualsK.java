package gfg160Days_DSA;

import java.util.HashMap;

public class Day049_SubarraySumEqualsK {

    public static int countSubarraysWithSumK(int[] arr, int k) {
        HashMap<Integer, Integer> prefixSumCounts = new HashMap<>();
        int count = 0;
        int currentSum = 0;

        // Initialize with prefix sum 0 occurring once
        prefixSumCounts.put(0, 1);

        for (int num : arr) {
            currentSum += num;
            // Check if there's a prefix sum that when removed leaves us with sum k
            if (prefixSumCounts.containsKey(currentSum - k)) {
                count += prefixSumCounts.get(currentSum - k);
            }
            // Record the current prefix sum
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 2, -2, -20, 10};
        int k1 = -10;
        System.out.println("Number of subarrays: " + countSubarraysWithSumK(arr1, k1)); // Output: 3

        int[] arr2 = {9, 4, 20, 3, 10, 5};
        int k2 = 33;
        System.out.println("Number of subarrays: " + countSubarraysWithSumK(arr2, k2)); // Output: 2
    }
}
