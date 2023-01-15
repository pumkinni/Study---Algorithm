// 알고리즘 - 최단 경로 알고리즘
// 벨만-포드

class Edge {

    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class BellmanFord {

    public static void bellmanFord(int v, int e, int[][] data, int start) {

        // 간선 정보 입력
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }

        // 최단거리 테이블 초기화
        int[] dijk = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            dijk[i] = Integer.MAX_VALUE;
        }
        dijk[start] = 0;
        boolean isMinusCycle = false;
        // v번 실행 -> 음수 사이클 확인
        for (int i = 0; i < v+1; i++) {
            // 모든 간선 확인
            for (int j = 0; j < e; j++) {
                Edge curEdge = edges[j];
                // 현재 간선 시작점의 최단거리 값이 무한이면 다음(아직 값이 할당이 안됨 : 무한 + 1 = 무한)
                if (dijk[curEdge.from] == Integer.MAX_VALUE){
                    continue;
                }
                // 현재 간선 끝점의 최단거리 값이 > 현재 간선 시작점의 최단거리 값 + 가중치 이면 갱신
                if (dijk[curEdge.to] > dijk[curEdge.from] + curEdge.weight){
                    dijk[curEdge.to] = dijk[curEdge.from] + curEdge.weight;
                    // v번째에서 갱신 발생시 -> 음수 사이클
                    if (i==v){
                        isMinusCycle = true;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println("음수 사이클 발생 : " + isMinusCycle);

        for (int i = 1; i < v+1; i++) {
            if (dijk[i] == Integer.MAX_VALUE){
                System.out.print("INF ");
            }
            System.out.print(dijk[i] + " ");
        }
        System.out.println();



    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        bellmanFord(7, 11, data, 1);
    }
}
