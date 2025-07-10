package gfg160Days_DSA;


import java.util.HashSet;

public class Day042_PairSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true; // Found a pair
            }
            seen.add(num);
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        int target1 = 16;
        System.out.println(hasPairWithSum(arr1, target1)); // true

        int[] arr2 = {1, 2, 4, 3, 6};
        int target2 = 11;
        System.out.println(hasPairWithSum(arr2, target2)); // false
    }
}
