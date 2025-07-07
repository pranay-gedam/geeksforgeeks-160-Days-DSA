package gfg160Days_DSA;

import java.util.Arrays;

public class Day033_AggresiveCows {

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Sort the stall positions
        int low = 1; // Minimum distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int answer = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Middle distance
            if (canPlaceCows(stalls, mid, k)) {
                answer = mid; // Update answer if placement is possible
                low = mid + 1; // Try for a bigger minimum distance
            } else {
                high = mid - 1; // Try for a smaller minimum distance
            }
        }

        return answer;
    }

    private static boolean canPlaceCows(int[] stalls, int minDist, int k) {
        int count = 1; // Place first cow at the first stall
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                count++; // Place a cow
                lastPosition = stalls[i];
                if (count == k) return true; // All cows placed
            }
        }
        return false; // Not able to place all cows
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println(aggressiveCows(stalls, k));
    }
}
