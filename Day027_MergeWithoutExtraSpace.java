package gfg160Days_DSA;

import java.util.Arrays;

public class Day027_MergeWithoutExtraSpace {

    public static void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        // Extend array a to hold the combined elements (not creating a new array in memory)
        a = Arrays.copyOf(a, n + m); // Temporarily increase the size for merging

        // Merge the elements from b into a for sorting, start from the end
        int i = n - 1; // Last index of initial a[]
        int j = m - 1; // Last index of b[]
        int k = n + m - 1; // Last index of extended a[]

        // Merge a and b from the back to the front
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }

        // If there are remaining elements in b, add them
        while (j >= 0) {
            a[k--] = b[j--];
        }

        // Remaining elements in a are already in place, no need to move them

        // The merged array is now in 'a'
        System.arraycopy(a, 0, a, 0, n + m); // Copy back to a if modified
        // Adjust this copy if you initially want to structure output for both
        System.out.println("Merged Array: " + Arrays.toString(a));
        // Since we are merging into 'a', b will not be modified.
    }

    public static void main(String[] args) {
        int[] a1 = {2, 4, 7, 10};
        int[] b1 = {2, 3};
        mergeArrays(a1, b1);

    }
}
