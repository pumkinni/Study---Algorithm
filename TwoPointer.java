// 알고리즘 - 투 포인터
// for-loop vs two pointers

import java.util.Arrays;

public class TwoPointer {
    public static int[] forLoop(int[] arr, int target) {
        int[] result = {-1,-1};
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
            if (sum == target){
                break;
            }
        }
        return result;
    }

    public static int[] twoPointers(int[] arr, int target) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int[] result = {-1, -1};

//        while (end < arr.length && start < arr.length){
//            if (sum == target){
//                result[0] = start;
//                result[1] = end-1;
//                return result;
//            }
//            if (sum < target){
//                sum += arr[end ++];
//            } else {
//                sum -= arr[start++];
//            }
//        }

        while (true){
            if (sum > target){
                sum -= arr[start++];
            } else if (end == arr.length) {
                break;
            } else {
                sum += arr[end++];
            }

            if (target == sum){
                result[0] = start;
                result[1] = end - 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 3, 7, 2, 4, 3, 2};
        System.out.println(Arrays.toString(forLoop(arr, 9)));
        System.out.println(Arrays.toString(forLoop(arr, 14)));
        System.out.println();

        System.out.println(Arrays.toString(twoPointers(arr, 9)));
        System.out.println(Arrays.toString(twoPointers(arr, 14)));
        System.out.println();

        int[] arr2 = {1,2,3,7,8,9};
        System.out.println(Arrays.toString(forLoop(arr2, 15)));
        System.out.println(Arrays.toString(twoPointers(arr2, 15)));


    }
}
