// 퀵 정렬

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }

        // 조건에 따라 swap 후 pivot값 구하기
        int pivot = partition(arr, left, right);

        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);

    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i < j){
            while (pivot < arr[j] && i<j){
                j --;
            }

            while (pivot >= arr[i] && i<j){
                i ++;
            }

            swap(arr, i, j);
        }
        swap(arr, left, i);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬: " + Arrays.toString(arr));
    }
}
