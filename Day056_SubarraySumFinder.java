package gfg160Days_DSA;

import java.util.Arrays;

public class Day056_SubarraySumFinder {
    public static int[] findSubarrayWithSum(int[] arr, int target) {
        int start = 0, currentSum = 0;
        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            // Shrink the window from the start if sum exceeds target
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // When sum matches target, return 1-based indices
            if (currentSum == target) {
                return new int[]{start + 1, end + 1};
            }
        }
        // No subarray found
        return new int[]{-1};
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 7, 5};
        int target1 = 12;
        System.out.println("Subarray indices for arr1: " + Arrays.toString(findSubarrayWithSum(arr1, target1))); // [2, 4]

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target2 = 15;
        System.out.println("Subarray indices for arr2: " + Arrays.toString(findSubarrayWithSum(arr2, target2))); // [1, 5]

        int[] arr3 = {5, 3, 4};
        int target3 = 2;
        System.out.println("Subarray indices for arr3: " + Arrays.toString(findSubarrayWithSum(arr3, target3))); // [-1]

        // Additional tests
        int[] arr4 = {2, 2, 2, 2, 2};
        int target4 = 6;
        System.out.println("Subarray indices for arr4: " + Arrays.toString(findSubarrayWithSum(arr4, target4))); // [1, 3]

        int[] arr5 = {0, 0, 0, 0};
        int target5 = 0;
        System.out.println("Subarray indices for arr5: " + Arrays.toString(findSubarrayWithSum(arr5, target5))); // [1, 1]
    }
}
