// Practice
// 배낭에 물품을 담으려고 한다.
// 배낭에는 k 무게 만큼의 물품을 담을 수 있다.
// n 개의 물품이 주어지고 이 물품의 무게와 가치 정보가 items 2차원 배열에 주어졌을 때,
// 최대 가치가 되도록 물품을 담았을 때의 가치를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// items: {{6, 13}, {4, 8}, {3, 6}, {5, 12}}
// n: 4
// k: 7
// 출력: 14

// 무게를 dp의 입력값으로 두고 각 물품의 무게를 넣어 최대 가치값을 입력한다.
public class DPPractice3 {

    public static int solution(int[][] items, int n, int k) {
        int[][] dp = new int[n+1][k+1];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (items[i][0] > j ){ // 추가하려고 하는 무게가 j kg 보다 크면 앞의 값을 가져옴
                    dp[i+1][j] = dp[i][j];
                } else { // j kg을 넘으면 현재 물건의 가치와 j-현재물건 무게의 최대 가치를 더함
                    dp[i+1][j] = Math.max(dp[i][j], items[i][1] + dp[i+1][j-items[i][0]]);
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        // Test code
        int[][] items = {{6, 13}, {4, 8}, {3, 6}, {5, 12}};
        System.out.println(solution(items, 4, 7));  // 14
    }
}
