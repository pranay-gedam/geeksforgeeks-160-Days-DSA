package gfg160Days_DSA;

import java.util.Arrays;

public class Day003_ReverseArray {

    public static void reverseArray(int arr[]) {
        int j = arr.length - 1;
        for(int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 5};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
