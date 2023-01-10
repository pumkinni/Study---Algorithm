
import java.util.Arrays;

public class BSPractice5 {
    public static int solution(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt(); // 최저합
        int right = Arrays.stream(nums).sum(); // 최고합

        while (left <= right){
            int mid = (left + right) / 2;  // 최저~ 최고합 사이의 어느 값(자른 수들의 합 중 가장 큰 값)

            int cnt = 1;
            int sum = 0;

            // mid 값의 합을 가졌을 때 자른 수 세기
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i]> mid){
                    cnt ++;
                    sum = 0;
                }
                sum += nums[i];
            }

            // cnt가 m보다 작거나 같다면 합을 줄여서 확인
            if (cnt <= m){
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(solution(nums, 2));  // 18

        nums = new int[] {1, 2, 3, 4, 5};
        System.out.println(solution(nums, 2));  // 9

        nums = new int[] {1, 4, 4};
        System.out.println(solution(nums, 3));  // 4
    }
}
