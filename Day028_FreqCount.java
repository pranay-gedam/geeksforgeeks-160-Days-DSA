package gfg160Days_DSA;

public class Day028_FreqCount {

    public static int countOccurrences(int[] arr, int target) {
        int firstIndex = findFirstOccurrence(arr, target);
        int lastIndex = findLastOccurrence(arr, target);

        if (firstIndex == -1 || lastIndex == -1) {
            return 0; // target not found
        } else {
            return lastIndex - firstIndex + 1; // count = last - first + 1
        }
    }

    private static int findFirstOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1; // default if not found

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1; // look for earlier occurrences
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static int findLastOccurrence(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int result = -1; // default if not found

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                low = mid + 1; // look for later occurrences
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
            int[] arr1 = {1, 1, 2, 2, 2, 2, 3};
            int target1 = 2;
            System.out.println(countOccurrences(arr1, target1)); // Output: 4

            int[] arr2 = {1, 1, 2, 2, 2, 2, 3};
            int target2 = 4;
            System.out.println(countOccurrences(arr2, target2)); // Output: 0

            int[] arr3 = {8, 9, 10, 12, 12, 12};
            int target3 = 12;
            System.out.println(countOccurrences(arr3, target3)); // Output: 3
    }
}
