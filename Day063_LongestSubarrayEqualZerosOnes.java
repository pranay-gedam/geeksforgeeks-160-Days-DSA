package gfg160Days_DSA;

import java.util.HashMap;
import java.util.Map;

public class Day063_LongestSubarrayEqualZerosOnes {

    public static int findMaxLength(int[] arr) {
        // Map to store the earliest index at which a particular cumulative sum occurs
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1); // Handle subarray starting from index 0

        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Treat 0 as -1, 1 as +1
            sum += (arr[i] == 0) ? -1 : 1;

            if (sumIndexMap.containsKey(sum)) {
                // Found a previous index with the same sum
                maxLength = Math.max(maxLength, i - sumIndexMap.get(sum));
            } else {
                // Store the earliest index for this sum
                sumIndexMap.put(sum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 1, 1, 1, 0, 0};
        int[] arr2 = {0, 0, 1, 1, 0};
        int[] arr3 = {0};

        System.out.println(findMaxLength(arr1)); // Output: 6
        System.out.println(findMaxLength(arr2)); // Output: 4
        System.out.println(findMaxLength(arr3)); // Output: 0
    }
}
