
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
