package gfg160Days_DSA;

public class Day012_maxCircularSubArraySum {

    public static int circularSubarraySum(int arr[]) {
        int n = arr.length;

        // Case 1: Max subarray sum using Kadane's Algorithm
        int max_kadane = kadane(arr);

        // Case 2: Max circular subarray sum
        int max_wrap = 0;
        for (int i = 0; i < n; i++) {
            max_wrap += arr[i]; // Calculate array-sum
            arr[i] = -arr[i]; // Invert the array (change sign of each element)
        }

        // Max sum with corner elements will be:
        // array-sum - (-max subarray sum of inverted array)
        max_wrap = max_wrap + kadane(arr);

        // The maximum will be the max of the two cases
        return (max_wrap > max_kadane) ? max_wrap : max_kadane;
    }

    // Standard Kadane's Algorithm to find maximum subarray sum
    public static int kadane(int[] arr) {
        int n = arr.length;
        int max_so_far = arr[0];
        int max_ending_here = arr[0];

        for (int i = 1; i < n; i++) {
            max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = {8, -8, 9, -9, 10, -11, 12};
        System.out.println(circularSubarraySum(arr));
    }
}
