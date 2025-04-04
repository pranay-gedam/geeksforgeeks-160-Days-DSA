package gfg160Days_DSA;

public class Day013_SmallestPositiveMissing {

    public static int missingNumber(int[] arr){
        int n = arr.length;

        // First, we will segregate positive numbers and negatives/zeros
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                arr[i] = n + 1; // Replace non-positive numbers with a value greater than n
            }
        }

        // Use the index as a hash to mark the presence of numbers
        for (int i = 0; i < n; i++) {
            int value = Math.abs(arr[i]);
            if (value <= n) {
                arr[value - 1] = -Math.abs(arr[value - 1]); // Mark the presence
            }
        }

        // Find the first index that is not negative
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1; // Return the smallest missing positive number
            }
        }

        // If all indices are negative, then the smallest missing is n + 1
        return n + 1;

    }

    public static void main(String[] args) {
        int[] arr = {2, -3, 4, 1, 1, 7};
        System.out.println(missingNumber(arr));
    }
}
