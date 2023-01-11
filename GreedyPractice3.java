
// 홀수일 경우 4의 배수쪽으로 만들기

public class GreedyPractice3 {
    public static int solution(int n) {
        if (n==0 || n==2){
            return 0;
        }

        if (n==1){
            return 0;
        }

        int cnt = 0;
        while (n != 1){
            if (n % 2 == 0){
                n /= 2;
            } else{
                if (n == 3){
                    return cnt + 2;
                }
                if ((n+1)%4 == 0){
                    n = n+1;
                }else {
                    n = n-1;
                }
            }
            cnt ++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(8));    // 3
        System.out.println(solution(7));    // 4
        System.out.println(solution(9));    // 4
        System.out.println(solution(6));    // 3
    }
}
