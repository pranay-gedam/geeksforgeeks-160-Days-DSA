package gfg160Days_DSA;

import java.util.HashMap;

public class Day062_LongestSubarraySum {

    public static int longestSubarray(int[] arr, int k) {
        // Map to store (cumulative sum -> earliest index)
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Check if sum equals k
            if (sum == k) {
                maxLength = i + 1;
            }

            // If (sum - k) exists, update maxLength
            if (sumMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - sumMap.get(sum - k));
            }

            // Store the earliest occurrence of this sum
            sumMap.putIfAbsent(sum, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 5, 2, 7, 1, -10};
        int k1 = 15;
        System.out.println("Longest subarray length for arr1: " + longestSubarray(arr1, k1));
        // Output: 6

        int[] arr2 = {-5, 8, -14, 2, 4, 12};
        int k2 = -5;
        System.out.println("Longest subarray length for arr2: " + longestSubarray(arr2, k2));
        // Output: 5

        int[] arr3 = {10, -10, 20, 30};
        int k3 = 5;
        System.out.println("Longest subarray length for arr3: " + longestSubarray(arr3, k3));
        // Output: 0
    }
}
