package gfg160Days_DSA;

import java.util.HashSet;
import java.util.Set;

public class Day047_LongestConsecutiveSequence {

    public static int findLongestConsecutiveSubsequence(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num : arr) {
            // Check if this is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                maxLength = Math.max(maxLength, currentStreak);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 1, 9, 4, 5, 3};
        System.out.println(findLongestConsecutiveSubsequence(arr1)); // Output: 6

        int[] arr2 = {1, 9, 3, 10, 4, 20, 2};
        System.out.println(findLongestConsecutiveSubsequence(arr2)); // Output: 4
    }
}
