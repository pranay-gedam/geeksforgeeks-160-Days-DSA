package gfg160Days_DSA;

public class Day031_PeakElement {

    public static int peakElement(int[] arr) {
        int n = arr.length;

        // Handle edge case for the first element
        if (n == 1 || arr[0] > arr[1]) {
            return 0; // peak at index 0
        }

        // Handle edge case for the last element
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1; // peak at the last index
        }

        // Main case: Check for peak in the middle of the array
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i; // Found a peak element
            }
        }

        // In case no peak found which should not happen here as per the constraints.
        return -1; // Indicate no peak found (should not be reached)
    }

    // Function to validate if the returned index is indeed a peak
    public boolean isValidPeak(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            return false;
        }
        int left = (index == 0) ? Integer.MIN_VALUE : arr[index - 1];
        int right = (index == arr.length - 1) ? Integer.MIN_VALUE : arr[index + 1];
        return arr[index] > left && arr[index] > right;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(peakElement(arr));
    }
}
