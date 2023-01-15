
// 음수 사이클이 있는지 확인 -> 벨만-포드 이용

public class SPPractice2 {
    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    final static int INF = 1000000000;
    static Edge[] edges;
    static int[] dist;

    public static void solution(int n, int m, int w, int[][] portal, int[][] wormhole) {

        // 그래프 생성
        edges = new Edge[m+w];
        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(portal[i][0], portal[i][1], portal[i][2]);
        }
        for (int i = 0; i < w; i++) {
            edges[m+i] = new Edge(wormhole[i][0], wormhole[i][1], -wormhole[i][2]);
        }

        // 최단 거리 테이블 초기화
        dist = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            dist[i] = INF;
        }

        System.out.println(bellmanFord(n, m+w));
    }

    public static boolean bellmanFord(int v, int e) {

        dist[1] = 0;

        for (int i = 0; i < v+1; i++) {
            // 모든 간선에 대하여 최단거리 수정
            for (int j = 0; j < e; j++) {
                Edge curEdge = edges[j];
                if (dist[curEdge.from] == INF){
                    continue;
                }
                if (dist[curEdge.to] > dist[curEdge.from] + curEdge.weight){
                    dist[curEdge.to] = dist[curEdge.from] + curEdge.weight;
                    if (i == v){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test code
        int n = 3;
        int m = 3;
        int w = 1;
        int[][] portal = {{1, 2, 2}, {1, 3, 4}, {2, 3, 1}};
        int[][] wormhole = {{3, 1, 3}};

        solution(n, m, w, portal, wormhole);  // false

        n = 3;
        m = 2;
        w = 1;
        portal = new int[][] {{1, 2, 3}, {2, 3, 4}};
        wormhole = new int[][] {{3, 1, 8}};
        solution(n, m, w, portal, wormhole);  // true
    }
}
