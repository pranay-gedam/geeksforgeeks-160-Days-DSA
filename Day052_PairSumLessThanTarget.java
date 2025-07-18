package gfg160Days_DSA;

import java.util.Arrays;

public class Day052_PairSumLessThanTarget {

    public static int countPairs(int[] arr, int target) {
        Arrays.sort(arr);  // Sort the array
        int count = 0;
        int left = 0;             // Start pointer
        int right = arr.length - 1; // End pointer

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum < target) {
                // All elements between left and right-1 will form valid pairs with arr[left]
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr1 = {7, 2, 5, 3};
        int target1 = 8;
        System.out.println(countPairs(arr1, target1)); // Output: 2

        int[] arr2 = {5, 2, 3, 2, 4, 1};
        int target2 = 5;
        System.out.println(countPairs(arr2, target2)); // Output: 4

        int[] arr3 = {2, 1, 8, 3, 4, 7, 6, 5};
        int target3 = 7;
        System.out.println(countPairs(arr3, target3)); // Output: 6
    }
}
