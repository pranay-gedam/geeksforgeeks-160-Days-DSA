package gfg160Days_DSA;

import java.util.Arrays;

public class Day002_MoveZeroToEnd {

    public static void pushZerosToEnd(int[] arr) {

        int lastNonZeroIndex = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[lastNonZeroIndex];
                arr[lastNonZeroIndex] = temp;
                lastNonZeroIndex++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        pushZerosToEnd(arr);
        System.out.println(Arrays.toString(arr));
    }
}
