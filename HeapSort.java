// 힙 정렬

import java.util.Arrays;

public class HeapSort {
    
    public static void heapSort(int[] arr) {
        // 자식노드가 있는 배열까지만 실행
        for (int i =  arr.length /2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // heapify 후 배열의 가장 앞에 값을 뒤에 고정 시킨다.
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }

    }

    public static void heapify(int[] arr, int parentIdx, int size) {
        // 부모 인덱스의 값이 자식 노드보다 크게 설정 후
        // 부모인덱스의 값이 바뀌었다면 그 자식 인덱스도 heapify를 재실행
        int leftIdx = parentIdx * 2 + 1;
        int rightIdx = parentIdx *2 + 2;
        int maxIdx = parentIdx;
        if (leftIdx < size && arr[leftIdx] > arr[maxIdx]){
            maxIdx = leftIdx;
        }
        if (rightIdx < size && arr[rightIdx] > arr[maxIdx]){
            maxIdx = rightIdx;
        }
        if (maxIdx != parentIdx){
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));

        arr = new int[]{5, 2, 7, 1, 4, 8};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
