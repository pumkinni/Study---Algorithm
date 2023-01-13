// Practice2
// 숫자 7193 은 7193 도 소수이고,
// 719, 71, 7 도 각각 소수이다.
// n 이 주어졌을 때, n 자리 수 중에 위와 같은 소수를 찾는 프로그램을 작성하세요.

// 입출력 예시
// 입력 n: 3
// 출력: 233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797


import java.util.ArrayList;

public class BTPractice2 {
    public static ArrayList<Integer> result;

    public static ArrayList<Integer> solution(int n) {
        result = new ArrayList<>();

        checkNext(n,0, 0);



        return result;
    }

    public static void checkNext(int n, int num, int depth){
        if (depth == n){
            result.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            int newNum = i + num * 10;

            if (checkPrime(newNum)){
                checkNext(n, newNum, depth+1);
            }
        }
    }

    public static boolean checkPrime(int num){
        if (num < 2){
            return false;
        }

        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));
    }
}
