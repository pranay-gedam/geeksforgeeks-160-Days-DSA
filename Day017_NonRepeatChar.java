package gfg160Days_DSA;

import java.util.*;

public class Day017_NonRepeatChar {

    public static char nonRepeatingChar(String s) {
        Map <Character, Integer> count = new LinkedHashMap<>();

        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : count.entrySet()){
            if(entry.getValue() == 1){
                entry.getKey();
            }
        }
        return '$';
    }

    public static void main(String[] args) {

    }
}
