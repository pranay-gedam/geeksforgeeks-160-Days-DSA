package gfg160Days_DSA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Day048_AnagramsGroups {

    public static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Use LinkedHashMap to preserve insertion order
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();
        for (String s : arr) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] arr1 = { "act", "god", "cat", "dog", "tac" };
        String[] arr2 = { "no", "on", "is" };
        String[] arr3 = { "listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art" };

        System.out.println("Test case 1:");
        System.out.println(anagrams(arr1));

        System.out.println("\nTest case 2:");
        System.out.println(anagrams(arr2));

        System.out.println("\nTest case 3:");
        System.out.println(anagrams(arr3));
    }
}
