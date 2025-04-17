package gfg160Days_DSA;

public class Day020_StringRotation {

    public static boolean areStringRotation(String str1, String str2){
        if (str1.length() != str2.length()) {
            return false;
        }
        String concatenated = str1 + str1;  // Concatenating A with itself
        return concatenated.contains(str2);  // Checking if B is a substring
    }

    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdab";
        System.out.println(areStringRotation(s1, s2));
    }
}
