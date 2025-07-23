package gfg160Days_DSA;

public class Day058_LengthOfLongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0; // sliding window start
        boolean[] exists = new boolean[256]; // ASCII charset

        for (int right = 0; right < n; right++) {
            // If character already exists in current window, move left pointer
            while (exists[s.charAt(right)]) {
                exists[s.charAt(left)] = false;
                left++;
            }

            // Mark current character as present
            exists[s.charAt(right)] = true;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        System.out.println("Input: \"" + s1 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s1));

        String s2 = "aaa";
        System.out.println("Input: \"" + s2 + "\"");
        System.out.println("Output: " + lengthOfLongestSubstring(s2));
    }
}
