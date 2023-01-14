// 알고리즘 - 최단 경로 알고리즘
// 다익스트라 기본 구현

import java.util.ArrayList;

class Node{
    int to;
    int weight;
    Node(){
    }

    Node(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

}

public class Dijkstra {


    public static void dijkstra(int v, int[][] data, int start) {
        // data 를 입력해서 그래프 만들기
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int[] da : data){
            graph.get(da[0]).add(new Node(da[1], da[2]));
        }

        // 최단거리를 저장할 메모리 생성
        int[] dijk = new int[v+1];
        for (int i = 1; i < dijk.length; i++) {
            dijk[i] = Integer.MAX_VALUE;
        }

        dijk[start] = 0;
        int targetIdx = start; // 타켓 인덱스 설정
        boolean[] visited = new boolean[v+1];

        for (int i = 0; i < v; i++) {  // 총 노드개수 번 반복

            // 타겟 인텍스 노드의 인접 노드들
            ArrayList<Node> adjNodes = graph.get(targetIdx);
            visited[targetIdx] = true;

            // targetIdx 의 인접 노드들에 최소 가중치 할당
            for (int j = 0; j < adjNodes.size(); j++) {
                Node adjNode = adjNodes.get(j);
                dijk[adjNode.to] = Math.min(dijk[adjNode.to], dijk[targetIdx]+adjNode.weight);
            }

            int weightMin = Integer.MAX_VALUE;

            // 할당된 노드의 방문하지 않은 노드 중 최소가중치를 가진 노드 찾기
            for (int j = 0; j < adjNodes.size(); j++) {
                int adjIdx = adjNodes.get(j).to;
                if (visited[adjIdx] == false && dijk[adjIdx] < weightMin){
                    weightMin = dijk[adjIdx];
                    targetIdx = adjIdx;
                }
            }
        }

        // 출력
        for (int i = 1; i < dijk.length; i++) {
            if (dijk[i] == Integer.MAX_VALUE) {
                System.out.println("INF ");
            } else {
                System.out.print(dijk[i] + " ");
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstra(5, data, 1);
    }
}
