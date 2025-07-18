package gfg160Days_DSA;

public class Day054_PairSumCounter {

    public static int countPairs(int[] arr, int target) {
        int count = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                // If elements are equal, handle duplicates
                if (arr[left] == arr[right]) {
                    int n = right - left + 1;
                    // Number of pairs when multiple duplicates of the same number
                    count += n * (n - 1) / 2;
                    break; // All pairs counted
                } else {
                    // Count duplicates of arr[left]
                    int countLeft = 1;
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        left++;
                        countLeft++;
                    }

                    // Count duplicates of arr[right]
                    int countRight = 1;
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        right--;
                        countRight++;
                    }

                    count += countLeft * countRight;
                    left++;
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else { // sum > target
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 1, 5, 5, 7};
        int target1 = 6;
        System.out.println(countPairs(arr1, target1)); // Output: 3

        int[] arr2 = {1, 1, 1, 1};
        int target2 = 2;
        System.out.println(countPairs(arr2, target2)); // Output: 6
    }
}
