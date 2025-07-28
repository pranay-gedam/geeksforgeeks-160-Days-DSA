package gfg160Days_DSA;

public class Day064_ProductArray {

    public static int[] constructProductArray(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        // Initialize prefix and suffix products
        int prefixProd = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefixProd;
            prefixProd *= arr[i];
        }

        int suffixProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffixProd;
            suffixProd *= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 3, 5, 6, 2};
        int[] result1 = constructProductArray(arr1);
        System.out.println(java.util.Arrays.toString(result1));

        int[] arr2 = {12, 0};
        int[] result2 = constructProductArray(arr2);
        System.out.println(java.util.Arrays.toString(result2));
    }
}
