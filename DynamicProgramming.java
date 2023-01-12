// 알고리즘 - 다이나믹 프로그래밍
// 피보나치 수열 구현 - 기본형, Tabulation, Memoization

public class DynamicProgramming {
    // 피보나치 수열 - 기본형 : O(n^2)
    // 계산 했던 부분 다시 계산
    public static int fib(int n) {
        if (n<=2){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
    // 피보나치 수열 - Tabulation : O(n)
    public static int fibDP(int n) {
        int[] memory = new int[n<2 ? 2:n+1];
        memory[0] = 0;
        memory[1] = 1;

        for (int i = 2; i <= n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n];
    }
    // 피보나치 수열 - memorization : O(n)
    static int[] memory = new int[8];
    public static int fibDP2(int n) {
        if (n <= 2){
            return 1;
        }

        // 값이 있다면 출력
        if (memory[n] != 0){
            return memory[n];
        }

        // 없으면 하위의 값으로 생성
        memory[n] = fibDP2(n-1) + fibDP2(n-2);

        return memory[n];

    }

    public static void main(String[] args) {
        // Test code
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDP2(7));
    }
}
