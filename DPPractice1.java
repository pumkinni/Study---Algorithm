

public class DPPractice1 {
    public static int solution(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0){
                dp[i] = Math.min(dp[i/2]+1, dp[i]);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i/3]+1, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2));    // 1
        System.out.println(solution(4));    // 2
        System.out.println(solution(9));    // 2
        System.out.println(solution(10));   // 3
    }
}
