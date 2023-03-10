// 방법 1
// 각 숫자의 뒤에 자기보다 작은 수가 있는지 확인
// 있다면 첫시작을 start로 두고 end는 계속 이동하며 있으면 end에 index값 할당
// end부터 다시 뒤에 자기보다 작은 수가 있는지 확인

public class SortPractice4 {
    public static int solution(int[] nums) {
        int start = -1;
        int end = -2;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = nums.length -1; j > Math.max(i , end); j--) {
                if (nums[i] > nums[j]){
                    if (start == -1){
                        start = i;
                    }
                    end = j;
                    break;
                }
            }
        }
        System.out.println(start + "/" + end);
        return end - start + 1;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 6, 4, 8, 5, 3, 9, 10};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 9, 3, 4, 5};
        System.out.println(solution(nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }
}
