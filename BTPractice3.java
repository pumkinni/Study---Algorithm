// Practice3
// sols 배열에 5지 선다 문제의 정답들이 적혀있다.
// 3번 연속 해서 같은 정답이 있는 경우가 없다는 것을 알아낸 후,
// 문제를 찍어서 푼다고 할 때, 5점 이상을 받을 경우의 수를 출력하세요.

// 문제는 총 10문제이며 각 문제당 1점이다.

// 입출력 예시
// sols: {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}
// 결과: 261622


public class BTPractice3 {
    final static int numOfProblems = 10;

    public static int cntA = 0;

    public static void solution(int[] sols) {
        if (sols == null || sols.length != numOfProblems) {
            return;
        }

        backtracking(sols, 0, -1, -1, 0);
        System.out.println(cntA);
        cntA = 0;

    }

    public static void backtracking(int[] sols, int answerCnt, int pre, int prePre, int depth){
        // 남은 문항수를 다 맞아도 5점이 안되는 경우
        if (5 - answerCnt > numOfProblems - depth ){
            return;
        }


        // 10개 다 확인하면 정답이 5개 이하 : 돌아가기, 이상 : cnt+1
        if (depth == 10){
            if (answerCnt >= 5){
                cntA += 1;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            // 중복이라면 해당 숫자빼고 진행
            if (pre == prePre && i == pre) {
                continue;
            }

            // 정답 확인 -> 정답이면 answerCnt +1 해서 재귀 아니면 answerCnt 그대로 두고 재귀
            if (sols[depth] == i) {
                backtracking(sols, answerCnt + 1, i, pre, depth + 1);
            } else {
                backtracking(sols, answerCnt, i, pre, depth + 1);
            }
        }

        return;
    }


    public static void main(String[] args) {
        // Test code
        int[] sols = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        solution(sols);

        sols = new int[] {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        solution(sols);
    }
}
