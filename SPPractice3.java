// 모든 노드 별 최단 거리 구하기 -> 플로이드 워셜 이용

public class SPPractice3 {

    static int[][] dist;
    static final int INF = 1000000000;

    public static void solution(int city, int bus, int[][] busInfo) {

        // 메모리 초기값 설정
        dist = new int[city+1][city+1];

        for (int i = 1; i < city+1; i++) {
            for (int j = 1; j < city+1; j++) {
                if (i!=j){
                    dist[i][j] = INF;
                }
            }
        }

        for (int[] path: busInfo){
            dist[path[0]][path[1]] = Math.min(dist[path[0]][path[1]],path[2]);
        }

        floydWarshall(city);

        // 출력
        for (int i = 1; i < city+1; i++) {
            for (int j = 1; j < city+1; j++) {
                if (dist[i][j] >= INF){
                    System.out.printf("%5s","0");
                } else {
                    System.out.printf("%5d", dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void floydWarshall(int v) {

        for (int k = 1; k < v+1; k++) {
            for (int i = 1; i < v+1; i++) {
                for (int j = 1; j < v+1; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF){
                        if (dist[i][j] > dist[i][k] + dist[k][j]){
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        int city = 5;
        int bus = 14;
        int[][] busInfo = {{1, 2, 2}, {1, 3, 3}, {1, 4, 1}, {1, 5, 10}, {2, 4, 2}, {3, 4, 1}, {3, 5, 1},
                {4, 5, 3}, {3, 5, 10}, {3, 1, 8}, {1, 4, 2}, {5, 1, 7}, {3, 4, 2}, {5, 2, 4}};
        solution(city, bus, busInfo);
    }
}
