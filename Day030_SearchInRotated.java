package gfg160Days_DSA;

public class Day030_SearchInRotated {

    public static int findKey(int[] arr, int key) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if mid is the key
            if (arr[mid] == key) {
                return mid;
            }

            // Determine if the left half is sorted
            if (arr[left] <= arr[mid]) {
                // Key is in the left half
                if (arr[left] <= key && key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right half must be sorted
                // Key is in the right half
                if (arr[mid] < key && key <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        // Key was not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key1 = 3;
        System.out.println("Index of " + key1 + ": " + findKey(arr1, key1)); // Output: 8

        int[] arr2 = {3, 5, 1, 2};
        int key2 = 6;
        System.out.println("Index of " + key2 + ": " + findKey(arr2, key2)); // Output: -1
    }
}
