package gfg160Days_DSA;

public class Day015_AddBinaryStrings {

    public static String addBinary(String s1, String s2){
        s1 = s1.replaceFirst("^0+(?!0)", "");
        s2 = s2.replaceFirst("^0+(?!0)", "");

        if(s1.isEmpty() && s2.isEmpty()){
            return "0";
        }

        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;

            if(i >= 0){
                sum += s1.charAt(i--) - '0';
            }

            if(j >= 0){
                sum += s2.charAt(j--) - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "1101";
        String s2 = "111";
        System.out.println(addBinary(s1, s2));
    }
}
