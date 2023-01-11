// Practice
// nums1 과 nums2 두 배열이 주어졌을 때
// 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성하세요.
// 결과 배열의 원소에는 중복 값이 없도록 하며 순서는 상관 없다.

// 입출력 예시
// nums1: 1, 2, 2, 1
// nums2: 2, 2
// 출력: 2

// nums1: 4, 9, 5
// nums2: 9, 4, 9, 8, 4
// 출력: 4, 9 (or 9, 4)

// 각 배열들을 오름차순으로 정렬 후 각 배열의 0인덱스 부터 비교
// 같으면 p1, p2를 다음 인덱스로 이동 후 비교, 다르면 더 작은 값이 다음 인덱스로 이동 후 비교

import java.util.ArrayList;
import java.util.Arrays;

public class TPPractice2 {
    public static int[] solution(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList();

        QuickSort(nums1, 0, nums1.length - 1);
        QuickSort(nums2, 0, nums2.length-1);

        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length){

            if (nums1[p1] == nums2[p2]){
                if (!list.contains(nums1[p1])) {
                    list.add(nums1[p1]);
                }
                p1++;
                p2++;
            } else{
                if (nums1[p1] < nums2[p2]){
                    p1++;
                } else {
                    p2++;
                }
            }


        }

        return list.stream().mapToInt(i->i).toArray();
    }

    // 퀵 정렬 연습
    public static int[] QuickSort(int[] nums, int left, int right){

        if (left >= right){
            return null;
        }

        int pivot = partition(nums, left, right);
        QuickSort(nums, left, pivot-1);
        QuickSort(nums, pivot+1, right);

        return nums;
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i<j){
            while (arr[j] > pivot && i<j){
                j--;
            }
            while (arr[i] <= pivot && i<j){
                i++;
            }
            swap(i,j,arr);
        }
        swap(left, i, arr);
        return i;
    }

    public static void swap(int i, int j, int[] arr){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }
}
