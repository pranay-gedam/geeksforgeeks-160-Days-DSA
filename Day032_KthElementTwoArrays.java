package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Day032_KthElementTwoArrays {

    public static int kthElement(int[] a, int[] b, int k){

        // 1. simple approach
//        int[] c = new int[a.length + b.length];
//        System.arraycopy(a,0, c, 0, a.length);
//        System.arraycopy(b, 0, c, a.length, b.length);
//        Arrays.sort(c);
//        return c[k - 1];

        //2. Modified Binary search
        // Ensure the first array is the smaller one to minimize binary search range
        if (a.length > b.length) return kthElement(b, a, k);

        int n = a.length, m = b.length;

        // Define binary search bounds
        int low = Math.max(0, k - m);         // Minimum elements we can take from a[]
        int high = Math.min(k, n);            // Maximum elements we can take from a[]

        // Perform binary search
        while (low <= high) {
            int cutA = (low + high) / 2;      // Number of elements taken from a[]
            int cutB = k - cutA;              // Remaining elements taken from b[]

            // Handle edge cases with sentinel values
            int leftA = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int leftB = (cutB == 0) ? Integer.MIN_VALUE : b[cutB - 1];
            int rightA = (cutA == n) ? Integer.MAX_VALUE : a[cutA];
            int rightB = (cutB == m) ? Integer.MAX_VALUE : b[cutB];

            // Check if valid partition
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB);  // Found the kth element
            } else if (leftA > rightB) {
                high = cutA - 1;  // Move left in a[]
            } else {
                low = cutA + 1;   // Move right in a[]
            }
        }

        return -1; // Should not reach here if k is valid
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kthElement(a, b, k));
    }
}
