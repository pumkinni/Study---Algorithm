// Practice1
// 정수형 배열 nums 가 주어졌다.
// 연속된 부분 배열의 합 중 가장 큰 값을 출력하세요.

// 입출력 예시
// nums: -5, 0, -3, 4, -1, 3, 1, -5, 8
// 출력: 10

// nums: 5, 4, 0, 7, 8
// 출력: 24

public class DACPractice1 {

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return divideSubArray(nums, 0, nums.length-1);
    }

    public static int divideSubArray(int[] nums, int left, int right){
        if (left == right){
            return nums[left];
        }

        int mid = left + (right - left)/2;

        // 왼쪽 배열중의 최대합 (재귀 형태로 배열의 크기가 1일때부터의 합 중 최대합)
        int maxLeft = divideSubArray(nums, left, mid);

        // 오른쪽 배열중의 최대합
        int maxRight = divideSubArray(nums, mid+1, right);

        // 모든 배열중 최대합
        int maxArr = getMaxSum(nums, left, mid, right);

        return Math.max(maxLeft, Math.max(maxRight, maxArr));
    }

    // (중앙을 시작으로)왼쪽 배열의 합중 가장 최대합 + 오른쪽 배열중 가장 최대합 구하기
    public static int getMaxSum(int[] nums, int left, int mid, int right){
        int maxLeft = Integer.MIN_VALUE;
        int sumLeft = 0;
        for (int i = mid; i >= left ; i--) {
            sumLeft += nums[i];
            maxLeft = Math.max(maxLeft, sumLeft);
        }

        int maxRight = Integer.MIN_VALUE;
        int sumRight = 0;
        for (int i = mid+1; i <= right; i++) {
            sumRight += nums[i];
            maxRight = Math.max(maxRight, sumRight);
        }

        return maxLeft+maxRight;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {-5, 0, -3, 4, -1, 3, 1, -5, 8};
        System.out.println(solution(nums));

        nums = new int[]{5, 4, 0, 7, 8};
        System.out.println(solution(nums));
    }
}
