package gfg160Days_DSA;

import java.util.Arrays;

public class Day021_Sort {

    // Function to sort array of 0s, 1s, and 2s.

    public static void sortArray(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 0, 0, 2, 1};
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
