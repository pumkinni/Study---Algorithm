// 최소 적재량, 최대 적재량을 구한후 이진 탐색으로 적재량을 받는다.
// 받은 적재량을 가지고 몇일 만에 가능한지(checkDay) 확인 ->  day < checkDay : 적재량 늘리기, day > checkDay : 적재량 줄이며 적재량을 찾아간다.

import java.util.Arrays;

public class BSPractice4 {
    public static int solution(int[] weights, int days) {

        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();

        while (left <= right){
            int mid = (left + right) /2;
            if (checkDay(weights, mid) == days){
                return mid;
            }
            if (checkDay(weights, mid) < days){ // 왼쪽이동
                right = mid - 1;
            } else { // 오른쪽 이동
                left = mid + 1;
            }
        }

        return 0;
    }

    public static int checkDay(int[] weights, int amount){
        int cntDay = 1;
        int sum = 0;

        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > amount){
                sum = weights[i];
                cntDay += 1;
            }
        }
        return cntDay;
    }

    public static void main(String[] args) {
        // Test code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5));   // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3));   // 6
    }
}
