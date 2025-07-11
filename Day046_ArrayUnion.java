package gfg160Days_DSA;

import java.util.HashSet;
import java.util.Set;

public class Day046_ArrayUnion {

    public static int findUnionCount(int[] a, int[] b) {
        Set<Integer> unionSet = new HashSet<>();

        // Add all elements from array a
        for (int num : a) {
            unionSet.add(num);
        }

        // Add all elements from array b
        for (int num : b) {
            unionSet.add(num);
        }

        // The size of the set is the number of unique elements in the union
        return unionSet.size();
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] b1 = {1, 2, 3};
        System.out.println(findUnionCount(a1, b1)); // Output: 5

        int[] a2 = {85, 25, 1, 32, 54, 6};
        int[] b2 = {85, 2};
        System.out.println(findUnionCount(a2, b2)); // Output: 7
    }
}
