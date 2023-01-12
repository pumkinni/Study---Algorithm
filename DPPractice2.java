

public class DPPractice2 {
    public static int solution(int[] arr) {
        int length = arr.length;
        int[] dp = new int[length+1];
        int max = 0;

        for (int i = 1; i < length+1; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i-1] > arr[j-1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = new int[]{10, 20, 30, 10, 50, 10};
        System.out.println(solution(arr));
    }
}
