package gfg160Days_DSA;

public class Day019_MinCharsToPalindrome {

    public static int minCharsToAdd(String s) {
        // Create a new string in the format "s#reverse(s)"
        String rev = new StringBuilder(s).reverse().toString();
        String concat = s + "#" + rev;

        // Calculate the LPS (longest prefix suffix) array
        int[] lps = computeLPS(concat);

        // The minimum characters to add = length of original string - length of LPS
        return s.length() - lps[lps.length - 1];
    }

    private static int[] computeLPS(String s) {
        int[] lps = new int[s.length()];
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;

        // The loop calculates lps[i] for i = 1 to s.length()-1
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // (s.charAt(i) != s.charAt(len))
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aacecaaaa";

        System.out.println(minCharsToAdd(s1)); // Output: 2
        System.out.println(minCharsToAdd(s2)); // Output: 2
    }
}
