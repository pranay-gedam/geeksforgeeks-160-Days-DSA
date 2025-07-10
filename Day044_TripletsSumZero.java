package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day044_TripletsSumZero {

    public static List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        int n = arr.length;

        // Iterate over all possible triplets with i < j < k
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        result.add(Arrays.asList(i, j, k));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        int[] arr2 = {1, -2, 1, 0, 5};
        int[] arr3 = {2, 3, 1, 0, 5};

        System.out.println("Triplets in arr1: " + findTriplets(arr1));
        System.out.println("Triplets in arr2: " + findTriplets(arr2));
        System.out.println("Triplets in arr3: " + findTriplets(arr3));
    }
}
