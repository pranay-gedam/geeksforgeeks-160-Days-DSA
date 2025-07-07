package gfg160Days_DSA;

public class Day035_KthMissingPositiveNumber {

    public static int findKthPositive(int[] arr, int k) {
        int missingCount = 0; // Count of missing positive numbers
        int currentNum = 1;   // Start checking from 1
        int i = 0;            // Index for the input array

        while (missingCount < k) {
            // Check if the current number is in the array
            if (i < arr.length && arr[i] == currentNum) {
                i++; // Move to the next element in the array
            } else {
                missingCount++; // Increment the count of missing numbers
                if (missingCount == k) {
                    return currentNum; // If we've found the kth missing number
                }
            }
            currentNum++; // Move to the next positive number
        }

        return -1; // This line should not be reached as k is guaranteed to be valid
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        System.out.println("The " + k1 + "th missing positive number is: " + findKthPositive(arr1, k1)); // Output: 9
    }
}
