// Practice4
// 2차원 배열 board 가 주어졌다.
// 해당 배열 데이터에는 'o', '#', '.' 의 정보가 기입되어 있다.
// 'o': 동전을 의미
// '#': 벽을 의미
// '.': 빈칸을 의미

// 동전은 항상 두개가 주어진다.
// 두 동전이 함께 이동하다가 하나가 보드에서 떨어지는 경우의 최소 이동 횟수를 출력하는 프로그램을 작성하세요.
// 단, 이동 규칙은 다음과 같다.
    // 동전은 좌, 우, 위, 아래로 이동 가능하며 같은 방향으로 함께 이동
    // 빈칸이나 동전이 있는 칸으로는 이동 가능
    // 벽일 때는 이동 불가
    // 이동 횟수가 10번을 넘으면 중지하고 -1 반환

// 입출력 예시
// board: {{'.', '#'}, {'.', '#'}, {'.', '#'}, {'o', '#'}, {'o', '#'}, {'#', '#'}}
// 결과: 4


public class BTPractice4 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int minCnt = Integer.MAX_VALUE;

    public static void solution(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int[] c1 = null;
        int[] c2 = null;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'o') {
                    if (c1 == null) {
                        c1 = new int[]{i, j};
                    } else {
                        c2 = new int[]{i, j};
                        break;
                    }
                }
                if (c2 != null) {
                    break;
                }
            }
        }
        move(board, visited, c1, c2, 0);

        minCnt = minCnt  > 10 ? -1:minCnt;

        System.out.println(minCnt);
        minCnt = Integer.MAX_VALUE;

    }
    public static void move(char[][]board, boolean[][] visited, int[] c1, int[] c2, int cnt){

        if (cnt >= minCnt){
            return;
        }

        if (cnt >= 10){
            return;
        }

        if (visited[c1[0]][c1[1]] == true){
            return;
        }
        visited[c1[0]][c1[1]] = false;
        // 두 동전의 현위치에서 상하좌우로 움직이기
        for (int[] dir : dirs){
            int x1 = c1[0] + dir[0];
            int x2 = c2[0] + dir[0];
            int y1 = c1[1] + dir[1];
            int y2 = c2[1] + dir[1];
            int xMax = board.length-1;
            int yMax = board[0].length - 1;
            // 둘 다 떨어지면 다음
            if ((x1<0||x1>xMax||y1<0||y1>yMax) && (x2<0||x2>xMax||y2<0||y2>yMax)){
                continue;
            }
            // 둘중 하나만 떨어지면
            if ((x1<0||x1>xMax||y1<0||y1>yMax) || (x2<0||x2>xMax||y2<0||y2>yMax)){

                minCnt = Math.min(cnt+1, minCnt);
                return;
            }

            // 둘 다 안떨어지면
            if (board[x1][y1] == '#'){  // 벽이 있는 곳은 움직이지 못하고 멈춰있음
                x1 = c1[0];
                y1 = c1[1];
            }

            if (board[x2][y2] == '#'){
                x2 = c2[0];
                y2 = c2[1];
            }

            move(board, visited, new int[]{x1,y1}, new int[]{x2,y2}, cnt+1);

        }
    }


    public static void main(String[] args) {
        // Test code
        char[][] board = {{'.', '#'}, {'.', '#'}, {'.', '#'}, {'o', '#'}, {'o', '#'}, {'#', '#'}};
        solution(board);

        board = new char[][] {{'#', '#', '#'}, {'.', 'o', '.'}, {'#', '.', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}};
        solution(board);

        board = new char[][] {{'#', '#', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}};
        solution(board);
    }
}
