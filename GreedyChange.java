// 거스름돈 문제

import java.util.HashMap;
import java.util.Map;

public class GreedyChange {
    public static void getChangeCoins(int receivedMoney, int price) {
        int[] coins = {500,100,50,10,5,1};
        Map<Integer,Integer> map = new HashMap<>();
        int change = receivedMoney - price;
        int cntA = 0;

        for (int coin : coins){
            if (coin > change){
                continue;
            }

            int cnt = change/coin;
            map.put(coin, cnt);
            change = change % coin;
            cntA += cnt;
        }

        System.out.println("총 동전 개수: " + cntA);

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Test code
        getChangeCoins(1000, 100);
        getChangeCoins(1234, 500);
    }
}
