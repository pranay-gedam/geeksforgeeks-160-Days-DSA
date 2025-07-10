package gfg160Days_DSA;

import java.util.HashMap;
import java.util.Map;

public class Day043_PairSumCounter {

        public static int countPairs(int[] arr, int target) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            int count = 0;

            for (int num : arr) {
                int complement = target - num;
                // If the complement exists, add the number of such pairs
                if (freqMap.containsKey(complement)) {
                    count += freqMap.get(complement);
                }
                // Add/increment the current number's frequency
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }
            return count;
        }
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 7, -1, 5};
        int target1 = 6;
        System.out.println("Number of pairs: " + countPairs(arr1, target1)); // Output: 3

        int[] arr2 = {1, 1, 1, 1};
        int target2 = 2;
        System.out.println("Number of pairs: " + countPairs(arr2, target2)); // Output: 6
    }
}

