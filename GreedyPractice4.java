
import java.util.Arrays;

public class GreedyPractice4 {
    public static int solution(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            cost[i] = gas[i] - cost[i];
        }
        if (Arrays.stream(cost).sum() < 0){
            return -1;
        }

        for (int i = 0; i < cost.length; i++) {
            if (cost[i] >= 0){
                int sum = cost[i];
                int idx = i;
                while (sum >= 0){
                    idx = (idx+1) % cost.length;
                    sum += cost[idx];
                    if (sum >=0 && idx == (i-1+cost.length) % cost.length ){
                        return i;
                    }
                }
                while (sum >= 0){
                    idx = (idx-1+cost.length) % cost.length;
                    sum += cost[idx];
                    if (sum >=0 && idx == (i+1+cost.length) % cost.length ){
                        return i;
                    }
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(solution(gas, cost));
    }
}
