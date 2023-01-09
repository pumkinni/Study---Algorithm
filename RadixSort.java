// 알고리즘 - 정렬_3
// 기수 정렬

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    public static void radixSort(int[] arr) {
        // 기수 테이블 생성
        ArrayList<Queue<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        // 자리수 구하기
        int maxLen = gerMaxLen(arr);
        int div = 1;

        // 자리수 만큼 정렬 반복
        for (int i = 0; i < maxLen; i++) {

            for (int j = 0; j < arr.length; j++) {
                int value = (arr[j] / div ) % 10;
                list.get(value).offer(arr[j]);
            }

            int idx = 0;
            for (Queue queue : list){
                while (!queue.isEmpty()){
                    arr[idx] = (int)queue.poll();
                    idx ++;
                }
            }
            div *= 10;
        }

    }

    // 최대 자리수 구하기
    private static int gerMaxLen(int[] arr){
        int maxLen = 0;
        for (int i = 0; i < arr.length ; i++) {
            int len = (int)Math.log10(arr[i]) + 1;
            maxLen = Math.max(len, maxLen);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }
}
