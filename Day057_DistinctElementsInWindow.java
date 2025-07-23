package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day057_DistinctElementsInWindow {
    public static ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0 || k > arr.length) {
            return result;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            // Include the new element in the window
            freqMap.put(arr[end], freqMap.getOrDefault(arr[end], 0) + 1);

            // Keep the window size at most k
            if (end - start + 1 > k) {
                // Remove or decrease the count of the element going out of the window
                int count = freqMap.get(arr[start]);
                if (count == 1) {
                    freqMap.remove(arr[start]);
                } else {
                    freqMap.put(arr[start], count - 1);
                }
                start++;
            }

            // When the window is exactly size k, record the number of distinct elements
            if (end - start + 1 == k) {
                result.add(freqMap.size());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 3, 4, 2, 3};
        int k1 = 4;
        System.out.println(countDistinct(arr1, k1)); // Output: [3, 4, 4, 3]

        int[] arr2 = {4, 1, 1};
        int k2 = 2;
        System.out.println(countDistinct(arr2, k2)); // Output: [2, 1]
    }
}
