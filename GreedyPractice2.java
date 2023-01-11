

public class GreedyPractice2 {
    public static int solution(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }

        int income = 0 ;
        for (int i=1; i<prices.length; i++){
            if (prices[i-1] < prices[i]){
                income += (prices[i] - prices[i-1]);
            }
        }

        return income;
    }

    public static void main(String[] args) {
        // Test code
        int[] prices = {5, 1, 6, 4, 3, 5};
        System.out.println(solution(prices));

        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(prices));

        prices = new int[]{5, 4, 3, 2, 1};
        System.out.println(solution(prices));
    }
}
