package gfg160Days_DSA;

import java.util.Arrays;

public class Day005_NextPermutation {

    // A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

    public static void nextPermutation(int[] arr) {

        int i = arr.length - 2;
        while(i >= 0 && arr[i] >= arr[i+1]){
            i--;
        }

        if(i < 0){
            reverse(arr, 0, arr.length - 1);
            return;
        }

        int j = arr.length - 1;
        while(arr[j] <= arr[i]){
            j--;
        }

        swap(arr, i, j);
        reverse (arr, i + 1, arr.length - 1);

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end){
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 5, 0};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));   // Output: [2, 4, 5, 0, 1, 7]
    }
}
