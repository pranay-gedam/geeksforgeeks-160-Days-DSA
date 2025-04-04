package gfg160Days_DSA;

public class Day011_MaxProductSubArray {

    public static int maxProduct(int[] arr) {

        if(arr.length == 0) return 0;

        int maxProduct = arr[0];
        int minProduct = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            if (current < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
                maxProduct = Math.max(current, maxProduct * current);
                minProduct = Math.min(current, minProduct * current);

                result = Math.max(result, maxProduct);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 6, -3, -10, 0, 2};
        System.out.println(maxProduct(arr));
    }
}
