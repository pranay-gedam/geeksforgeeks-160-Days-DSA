package gfg160Days_DSA;

public class Day051_CountTriplets {

    public static int countTriplets(int[] arr, int target) {
        int count = 0;
        int n = arr.length;

        for(int i = 0; i < n - 2; i++){
            int left = i + 1;
            int right = n - 1;

            while(left < right){
                int currentSum = arr[i] + arr[left] + arr[right];

                if(currentSum == target){
                    if(arr[left] == arr[right]){
                        int duplicates = right - left + 1;
                        count += (duplicates * (duplicates - 1)) / 2;
                        break;
                    } else {
                        int countLeft = 1;
                        while(left + countLeft < right && arr[left + countLeft] ==arr[left]){
                            countLeft++;
                        }
                        int countRight = 1;
                        while(right - countRight >= left && arr[right - countRight] == arr[right]){
                            countRight++;
                        }
                        count += countLeft * countRight;
                        left += countLeft;
                        right -= countRight;
                    }

                }else if(currentSum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {-3, -1, -1, 0, 1, 2}, target = -2;
        System.out.println(countTriplets(arr, target));
    }
}
