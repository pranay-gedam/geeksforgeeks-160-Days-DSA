package gfg160Days_DSA;

import java.util.Arrays;

public class Day009_MinimizeHeights {

    public static int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int res = arr[n - 1] - arr[0];
        for(int i = 1; i < arr.length; i++){
            if (arr[i] - k < 0) continue;
            int minH = Math.min(arr[0] + k, arr[i] - k);
            int maxH = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            res = Math.min(res, maxH - minH);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 9, 12, 16, 20};
        int k = 3;
        System.out.println(getMinDiff(arr, k));
    }
}
