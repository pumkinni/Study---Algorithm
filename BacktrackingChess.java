// 백트래킹
// 체스판 N-Queen 문제
public class BacktrackingChess {
    static int n = 4;
    static int cnt;
    static int[] board = new int[n];

    public static int nQueen(int row) {

        // 끝 행까지 오면 cnt +1, 보드 출력
        if (n == row){
            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            cnt++;
            return cnt;
        }

        // row행에서 말을 둘 곳을 0~n-1까지 움직이면서 확인
        for (int i = 0; i < n; i++) {
            board[row] = i;

            // 말을 놓을 수 있으면 다음 행으로 넘어감
            if (isPromising(row)){
                nQueen(row+1);
            }
        }

        return cnt;
    }

    // 체스 말을 놓아도 되는가 검즘 (현재 행까지만 검사)
    public static boolean isPromising(int row){
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || Math.abs(board[i] - board[row]) == row - i){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수: " + nQueen(0));  // 2
    }
}
