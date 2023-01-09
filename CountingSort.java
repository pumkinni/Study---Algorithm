// 계수 정렬

import java.util.*;

public class CountingSort {
    public static void countingSort(int[] arr) {
        // 방법1 : 배열 사용
        int maxNum = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[maxNum+1];

        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++;

        }

        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) {
            while (cntArr[i] > 0){
                arr[idx++] = i;
                cntArr[i] --;
            }
        }

        // 방법 2
        // 한 데이터의 크기가 너무 커서 배열의 크기가 너무 커질경우 해시맵 사용
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int idx2 = 0;
        for (int i = 0; i < list.size(); i++) {
            int cnt = map.get(list.get(i));
            for (int j = 0; j < cnt; j++) {
                arr[idx2] = list.get(i);
                idx2 ++;
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 10, 27, 32, 17, 99, 56};
        countingSort(arr);
        System.out.println("계수 정렬: " + Arrays.toString(arr));
    }
}
