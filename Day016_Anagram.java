package gfg160Days_DSA;

public class Day016_Anagram {

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a frequency array for storing counts of each character
        int[] charCount = new int[26];

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++; // Increment count for characters in s1
        }

        // Subtract counts using characters from s2
        for (char c : s2.toCharArray()) {
            charCount[c - 'a']--; // Decrement count for characters in s2
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false; // Non-zero count means not an anagram
            }
        }

        return true; // All counts are zero, hence they are anagrams
    }

    public static void main(String[] args) {
        String s1 = "allergy", s2 = "allergic" ;
        System.out.println(areAnagrams(s1, s2));
    }
}
