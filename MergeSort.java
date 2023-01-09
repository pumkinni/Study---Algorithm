// 알고리즘 - 정렬_2
// 합병 정렬

import java.util.Arrays;

public class MergeSort {
    
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        // 배열을 중앙값을 기준으로 분할
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right, mid);
        }
    }

    // 분할된 배열 합병
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left; // 왼쪽 배열의 인덱스를 지정
        int q = mid + 1; // 분할된 오른쪽 배열의 인덱스를 지정
        int idx = p; // tmp 인덱스를 지정

        // 왼쪽 배열, 오른쪽 배열의 인덱스가 범위를 벗어나지 않았을 때
        while (p <= mid || q <= right){
            if (p <= mid && q <= right){  // 왼쪽, 오른쪽 둘다 범위 안에 있다면
                if (arr[p] < arr[q]){ // 더 작은 값을 tmp배열에 삽입
                    tmp[idx ++] = arr[p++];
                } else {
                    tmp[idx ++] = arr[q++];
                }
            } else if (p <= mid && q > right) { // 왼쪽만 남아있다면 왼쪽값을 tmp배열에 삽입
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++]; // 오른쪽만 남아있으면 오른쪽 값을 tmp배열에 삽입
            }
        }
        // 임시로 저장한 tmp배열의 값들을 arr배열에 옮겨주기
        for (int i = left; i < right+1; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }
}
