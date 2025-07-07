package gfg160Days_DSA;

public class Day034_BookAllocation {

    // Function to check if it is possible to allocate books with given max pages
    private static boolean isAllocationPossible(int[] arr, int k, int maxPages) {
        int studentCount = 1; // Start with one student
        int pagesAllocated = 0; // Pages allocated to the current student

        for (int pages : arr) {
            // If adding this book exceeds maxPages, allocate books to the next student
            if (pagesAllocated + pages > maxPages) {
                studentCount++; // Allocate to another student
                pagesAllocated = pages; // Start with the current book's pages

                // If we exceed the number of students, return false
                if (studentCount > k) {
                    return false;
                }
            } else {
                pagesAllocated += pages; // Continue adding pages
            }
        }
        return true; // Allocation possible
    }

    // Function to find the minimum maximum pages allocated
    public static int findMinPages(int[] arr, int k) {
        int n = arr.length;

        // If number of students is greater than number of books
        if (n < k) {
            return -1; // Invalid allocation
        }

        // Initialize the binary search bounds
        int low = 0;
        int high = 0;

        // Calculate the total number of pages and set the initial values
        for (int pages : arr) {
            low = Math.max(low, pages); // Maximum single book pages
            high += pages; // Total pages
        }

        int result = high; // To store the minimum of the possible maximum pages

        // Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid

            // Check if we can allocate books such that max pages are mid
            if (isAllocationPossible(arr, k, mid)) {
                result = mid; // Update result
                high = mid - 1; // Try to find a smaller max
            } else {
                low = mid + 1; // Increase max pages
            }
        }
        return result; // Return final result
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findMinPages(arr, k));
    }
}
