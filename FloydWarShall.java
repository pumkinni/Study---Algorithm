// 알고리즘 - 최단 경로 알고리즘
// 플로이드-워셜

public class FloydWarShall {
    static int[][] dist;
    // OverFlow가 발생하지 않게 적당히 큰값 할당
    static final int INF = 100000000;

    public static void floydWarshall(int v, int e, int[][] data, int start) {
        // 최단거리 테이블 생성
        dist = new int[v+1][v+1];
        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++) {
                if (i!=j){
                    dist[i][j] = INF;
                }
            }
        }

        // 최단거리 테이블에 간선 정보 할당
        for (int i = 0; i < e; i++) {
            dist[data[i][0]][data[i][1]] = data[i][2];
        }

        // i->j로 갈때 중간값 k를 거쳐서 가는 경우가 짧을 때 최단거리 갱신
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

        // 결과 값 출력

        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++) {
                if (dist[i][j] >= INF){
                    System.out.printf("%5s","INF");
                }else {
                    System.out.printf("%5d", dist[i][j]);
                }
            }
            System.out.println();
        }


    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
        System.out.println();

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
    }
}
