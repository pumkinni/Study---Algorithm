
// index 0 부터 최대로 갈 수 있는 곳까지의 최대값들을 구해가기
public class GreedyPractice1 {
    public static boolean solution(int[] nums) {

        int max = 0;
        int cur = 0;

        while (cur < nums.length && cur <= max){
            max = Math.max(max, cur + nums[cur]);
            if (max >= nums.length){
                return true;
            }
            cur++;
        }

        return false;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(solution(nums));

        nums = new int[]{3, 0, 0, 1, 1};
        System.out.println(solution(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(solution(nums));
    }
}
