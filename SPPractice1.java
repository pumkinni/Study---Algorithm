// Practice1
// 2차원 배열 data 에 그래프 데이터가 주어졌다.
// 무방향이고 간선에 가중치 값이 있는 그래프이다.
// 1번 정점에서 N 번 정점으로 최단 경로로 이동하려고 하는데,
// 두 정점을 경유해서 가려고 한다.
// 1번 점점에서 출발하여 두 정점을 경유하여 N 번 정점으로 가는 최단 경로를 구하세요.

// 입출력 예시)
// 입력 data: {{1, 2, 3}, {1, 3, 5}, {1, 4, 4}, {2, 3, 3}, {2, 4, 5}, {3, 4, 1}}
// 출력: 7

// 플로이드워셜 방법으로 풀어보기



public class SPPractice1 {
    static int[][] dist;
    static final int INF = 100000000;
    public static void floydWarShall(int[][] data, int v){
        // 메모리 생성
        dist = new int[v+1][v+1];
        for (int i = 1; i < v+1; i++) {
            for (int j = 1; j < v+1; j++) {
                if (i!=j){
                    dist[i][j] = INF;
                }
            }
        }

        // 간선 정보 입력
        for (int[] da: data){
            dist[da[0]][da[1]] = da[2];
            dist[da[1]][da[0]] = da[2];
        }

        // i->j 로 갈때 k를 거쳐서 가는 경우 최단거리가 더 적으면 값 갱신
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

    public static int solution(int[][] data, int v, int via1, int via2, int start, int n) {
        floydWarShall(data, v);

        int p1 = dist[start][via1] + dist[via1][via2] + dist[via2][n];
        int p2 = dist[start][via2] + dist[via2][via1] + dist[via1][n];

        return  Math.min(p1, p2);
    }

    public static int dijkstra(int v, int start, int end) {
        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 3}, {1, 3, 5}, {1, 4, 4}, {2, 3, 3}, {2, 4, 5}, {3, 4, 1}};
        int v = 4;
        int via1 = 2;
        int via2 = 3;
        int start = 1;
        int n = 4;
        System.out.println(solution(data, v, via1, via2, start, n));
    }
}
