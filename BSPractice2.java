
// 원형 정렬 상태 배열에서의 이진 탐색

public class BSPractice2 {
    public static int solution(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;

            if (arr[mid] == target){
                return mid;
            }

            if (arr[mid] > arr[left]) {
                if (arr[mid] > target && target > arr[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < target && target < arr[right]){
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        System.out.println(solution(nums, 0));  // 5
        System.out.println(solution(nums, 3));  // -1
    }
}
