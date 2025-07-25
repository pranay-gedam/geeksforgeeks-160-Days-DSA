package gfg160Days_DSA;

public class Day060_maxWaterContainer {

    public static int maxArea(int[] arr) {
        int maxArea = 0;
        int left = 0;                  // Start pointer
        int right = arr.length - 1;    // End pointer

        while (left < right) {
            // Calculate current area
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int currentArea = height * width;

            // Update maxArea if current is larger
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that points to the shorter line
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 4, 3};
        int[] arr2 = {3, 1, 2, 4, 5};
        int[] arr3 = {2, 1, 8, 6, 4, 6, 5, 5};

        System.out.println("Maximum water contained (arr1): " + maxArea(arr1)); // 6
        System.out.println("Maximum water contained (arr2): " + maxArea(arr2)); // 12
        System.out.println("Maximum water contained (arr3): " + maxArea(arr3)); // 25
    }
}
