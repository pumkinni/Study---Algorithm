// 알고리즘 - 정렬_1

import java.util.Arrays;

public class InplaceSorts {
    // 오름차순 기준 정렬 알고리즘

    // 버블 정렬
    public static void bubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = 1; j < arr.length-i; j++) {
//                if (arr[j] < arr[j-1]){
//                    int tmp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = tmp;
//                }
//            }
//        }

        // 위와 같은 코드이지만 i의 값을 반대로 설정함
        for (int i = arr.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }
    
    // 삽입 정렬
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                } else{
                    break;
                }
            }
        }

    }

    // 선택 정렬
    private static void selectionSort(int[] arr) {
        // 오름차순 정렬
//        for (int i = 0; i < arr.length-1; i++) {
//            int min = i;
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[j] < arr[min]){
//                    min = j;
//                }
//            }
//            int tmp = arr[i];
//            arr[i] = arr[min];
//            arr[min] = tmp;
//        }

        // 내림차순 정렬
        for (int i = 0; i < arr.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[max] < arr[j]){
                    max = j;
                }
            }

            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));

    }
}
