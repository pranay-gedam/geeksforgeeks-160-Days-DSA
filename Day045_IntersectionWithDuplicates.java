package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Day045_IntersectionWithDuplicates {

    public static ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        Set<Integer> uniqueA = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        // Add all elements of array a to a set for quick lookup
        for (int num : a) {
            uniqueA.add(num);
        }

        // For each element in array b, check if it exists in uniqueA
        for (int num : b) {
            if (uniqueA.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert the result set to a list
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 1};
        int[] b = {3, 1, 3, 4, 1};
        ArrayList<Integer> result = intersectionWithDuplicates(a, b);
        Collections.sort(result);
        System.out.println(result); // Output: [1, 3]
    }
}
