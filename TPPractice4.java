
// 정렬 후
// index 0 부터 숫자 index n을 기준으로 잡고 나머지 숫자의 합이 0-index n 이 있는지 확인


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TPPractice4 {
    public static ArrayList<ArrayList<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> keys = new ArrayList<>();

        for (int i=0; i<nums.length-2; i++){
            if (keys.contains(nums[i])){
                break;
            }
            int p1 = i+1;
            int p2 = nums.length - 1;
            int target = 0-nums[i];

            while (p1 < p2){
                int sum = nums[p1] + nums[p2];
                if (sum == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[p1]);
                    list.add(nums[p2]);
                    keys.add(nums[i]);
                    result.add(list);
                    while (p1 < p2 && nums[p1] == nums[p1+1]){
                        p1++;
                    }
                    while (p1 < p2 && nums[p2] == nums[p2-1]){
                        p2--;
                    }
                    p1++;
                    p2--;
                } else if (sum < target) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {-1, 0, 1, 2, -1, -4};     // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(solution(nums));

        nums = new int[] {1, -7, 6, 3, 5, 2};   // [[-7, 1, 6], [-7, 2, 5]]
        System.out.println(solution(nums));
    }
}
