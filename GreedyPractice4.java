// Practice
// 원형 루트 상에 n 개의 주유소가 있다.
// 각 주유소의 가스 보유량은 gas 배열에 주어지고,
// 해당 주유소에서 다음 주유소로의 이동 비용은 cost 배열에 주어진다.

// 어떤 위치에서 차량이 가스를 채워 출발하면 모든 주유소를 방문하고 원래의 위치로 돌아올 수 있는지
// 계산하는 프로그램을 작성하세요.

// 입출력 예시
// gas: 1, 2, 3, 4, 5
// cost: 3, 4, 5, 1, 2
// 출력: 3

// gas: 2, 3, 4
// cost: 3, 4, 3
// 출력: -1


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
