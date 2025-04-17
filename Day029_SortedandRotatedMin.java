package gfg160Days_DSA;

public class Day029_SortedandRotatedMin {

    public static int findMinimum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid element is greater than the rightmost element
            if (arr[mid] > arr[right]) {
                // Minimum element is in the right half
                left = mid + 1;
            } else {
                // Minimum element is in the left half or it is the mid itself
                right = mid;
            }
        }

        // The left pointer will be at the minimum element
        return arr[left];
    }

    public static void main(String[] args) {
        int [] arr = {5, 6, 1, 2, 3, 4};
        System.out.println(findMinimum(arr));
    }
}
