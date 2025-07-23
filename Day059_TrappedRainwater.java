package gfg160Days_DSA;

public class Day059_TrappedRainwater {

    public static int trap(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        int totalWater = 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMax array
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Fill rightMax array
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // Calculate trapped water at each position
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 0, 1, 0, 4, 0, 2};
        int[] arr2 = {3, 0, 2, 0, 4};
        int[] arr3 = {1, 2, 3, 4};
        int[] arr4 = {2, 1, 5, 3, 1, 0, 4};

        System.out.println("Trapped water for arr1: " + trap(arr1)); // 10
        System.out.println("Trapped water for arr2: " + trap(arr2)); // 7
        System.out.println("Trapped water for arr3: " + trap(arr3)); // 0
        System.out.println("Trapped water for arr4: " + trap(arr4)); // 9
    }
}
