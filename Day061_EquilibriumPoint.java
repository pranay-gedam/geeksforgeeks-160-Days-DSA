package gfg160Days_DSA;

public class Day061_EquilibriumPoint {

    public static int findEquilibriumPoint(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i]; // now totalSum is sum on the right
            if (leftSum == totalSum) {
                return i; // equilibrium index found
            }
            leftSum += arr[i]; // update leftSum for next iteration
        }
        return -1; // no equilibrium point found
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 0, 3};
        int[] arr2 = {1, 1, 1, 1};
        int[] arr3 = {-7, 1, 5, 2, -4, 3, 0};

        System.out.println(findEquilibriumPoint(arr1)); // Output: 2
        System.out.println(findEquilibriumPoint(arr2)); // Output: -1
        System.out.println(findEquilibriumPoint(arr3)); // Output: 3
    }
}
