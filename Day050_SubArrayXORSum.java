package gfg160Days_DSA;

import java.util.HashMap;

public class Day050_SubArrayXORSum {

    public static int countSubarraysWithXor(int[] arr, int k) {
        HashMap<Integer, Integer> prefixXorFreq = new HashMap<>();
        int count = 0;
        int prefixXor = 0;

        for (int num : arr) {
            prefixXor ^= num;

            // If prefixXor equals k, increment count
            if (prefixXor == k) {
                count++;
            }

            // Check if there is a prefix XOR that when XORed with current gives k
            int target = prefixXor ^ k;
            if (prefixXorFreq.containsKey(target)) {
                count += prefixXorFreq.get(target);
            }

            // Update the frequency of the current prefixXor
            prefixXorFreq.put(prefixXor, prefixXorFreq.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 2, 6, 4};
        int k1 = 6;
        System.out.println("Count: " + countSubarraysWithXor(arr1, k1)); // Output: 4

        int[] arr2 = {5, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println("Count: " + countSubarraysWithXor(arr2, k2)); // Output: 2

        int[] arr3 = {1, 1, 1, 1};
        int k3 = 0;
        System.out.println("Count: " + countSubarraysWithXor(arr3, k3)); // Output: 4
    }
}
