package gfg160Days_DSA;

import java.util.Arrays;

public class Day055_TriangleCount {
    public static int countTriangles(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;

        // Fix the longest side `c` starting from the end
        for (int c = n - 1; c >= 2; c--) {
            int left = 0;
            int right = c - 1;
            while (left < right) {
                if (arr[left] + arr[right] > arr[c]) {
                    // All elements between left and right-1 will form triangles with arr[c] and arr[right]
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 6, 3, 7};
        int[] arr2 = {10, 21, 22, 100, 101, 200, 300};
        int[] arr3 = {1, 2, 3};

        System.out.println("Number of triangles in arr1: " + countTriangles(arr1)); // Output: 3
        System.out.println("Number of triangles in arr2: " + countTriangles(arr2)); // Output: 6
        System.out.println("Number of triangles in arr3: " + countTriangles(arr3)); // Output: 0
    }
}
