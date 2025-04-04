package gfg160Days_DSA;

public class Day014_AtoiConverter {

    // Given a string s, the objective is to convert it into integer format without utilizing any built-in functions.

    public static int myAtoi(String s){
        // Step 1: Skip leading whitespaces
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Check for a sign
        int sign = 1; // Default is positive
        if (index < s.length()) {
            char firstChar = s.charAt(index);
            if (firstChar == '+' || firstChar == '-') {
                sign = (firstChar == '-') ? -1 : 1;
                index++;
            }
        }

        // Step 3: Read the integer and ignore leading zeros
        long result = 0; // Use long to avoid overflow
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            if (currentChar < '0' || currentChar > '9') {
                break; // Non-digit character encountered
            }

            // Step 4: Update the result
            result = result * 10 + (currentChar - '0');
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }

        // Return the result with the sign
        return (int) result * sign;
    }

    public static void main(String[] args) {
        String str = "-123";
        System.out.println(myAtoi(str));
    }
}
