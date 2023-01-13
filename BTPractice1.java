// Practice1
// 정수형 n과 m이 주어졌을 때,
// 1 부터 n 까지의 정수 중에서 중복 없이 m 개를 고른 수열을 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n: 3
// m: 2
// 출력: [1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]

import java.util.Arrays;

public class BTPractice1 {

    public static void solution(int n, int m) {

        boolean[] visited = new boolean[n];
        int[] out = new int[m];

        pickNextNum(n,m,visited,0, out);
    }

    public static void pickNextNum(int n, int m, boolean[] visited, int depth, int[] out){

        if (depth == m){
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false){
                visited[i] = true;
                out[depth] = i+1;
                pickNextNum(n, m, visited, depth+1, out);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        solution(3, 2);
        System.out.println();
        solution(4, 3);
    }
}
