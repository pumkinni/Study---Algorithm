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
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int[] da : data){
            graph.get(da[0]).add(new Node(da[1], da[2]));
        }

        int[] dijk = new int[v+1];

        dijk[start] = 0;
        int targetIdx = start;
        boolean[] visited = new boolean[v+1];
        for (int i = 0; i < v; i++) {  // 총 노드개수 번 반복

            // 그 노드에서 인접 노드들에 가중치 할당
            ArrayList<Node> adjNodes = graph.get(targetIdx);
            visited[targetIdx] = true;

            for (int j = 0; j < adjNodes.size(); j++) { // targetIdx의 인접 노드들에 최소 가중치 할당
                int adjIdx = adjNodes.get(j).to;
                dijk[adjIdx] = Math.min(dijk[adjIdx], dijk[targetIdx]+adjNodes.get(j).weight);
            }

            int weightMin = Integer.MAX_VALUE;

            // 할당된 노드들 중 방문하지 않은 노드 중 최소가중치를 가진 노드 찾기
            for (int j = 0; j < adjNodes.size(); j++) {
                int adjIdx = adjNodes.get(j).to;
                if (visited[adjIdx] == false && dijk[adjIdx] < weightMin){
                    weightMin = dijk[adjIdx];
                    targetIdx = adjIdx;
                }
            }
        }

        for (int i = 1; i < dijk.length; i++) {
            System.out.println(dijk[i] + " ");
        }

    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstra(5, data, 1);
    }
}
