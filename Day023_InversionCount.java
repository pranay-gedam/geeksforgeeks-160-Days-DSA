package gfg160Days_DSA;

public class Day023_InversionCount {

    // Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.
    //
    //Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
    //If an array is sorted in the reverse order then the inversion count is the maximum.

    // Function that counts inversions using Modified Merge Sort
    public static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int count = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // Merge the two arrays and count the inversions
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                // There are mid - i inversions, because all remaining elements
                // in leftArr (from i to n1) are greater than rightArr[j]
                count += (n1 - i);
            }
        }

        // Copy the remaining elements
        while (i < n1)
            arr[k++] = leftArr[i++];
        while (j < n2)
            arr[k++] = rightArr[j++];

        return count;
    }

    public static int mergeSortAndCount(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;

            count += mergeSortAndCount(arr, left, mid);
            count += mergeSortAndCount(arr, mid + 1, right);

            // Count inversions merged
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    public static int inversionCount(int arr[]) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
       int arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));
    }
}
