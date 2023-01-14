// 다익스트라 우선순위 큐 사용

import java.util.ArrayList;
import java.util.PriorityQueue;

class Node1{
    int to;
    int weight;
    Node1(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}

public class PQDijkstra {

    public static void dijkstra(int v, int[][] data, int start) {
        // 그래프 생성
        ArrayList<ArrayList<Node1>> graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] da: data) {
            graph.get(da[0]).add(new Node1(da[1], da[2]));
        }

        // 최소 가중치를 담을 메모리 생성
        int[] dijk = new int[v+1];
        for (int i = 1; i < dijk.length; i++) {
            dijk[i] = Integer.MAX_VALUE;
        }

        dijk[start] = 0;

        PriorityQueue<Node1> pq = new PriorityQueue<>((x,y)->(x.weight - y.weight));

        pq.add(new Node1(start, 0));

        while (!pq.isEmpty()){
            Node1 curNode = pq.poll();

            if (dijk[curNode.to] < curNode.weight){
                continue;
            }
            ArrayList<Node1> adjNodes = graph.get(curNode.to);
            for (int i = 0; i < adjNodes.size(); i++) {
                Node1 adjNode = adjNodes.get(i);
                if (dijk[adjNode.to] > dijk[curNode.to] + adjNode.weight){
                    dijk[adjNode.to] = dijk[curNode.to] + adjNode.weight;
                    pq.offer(new Node1(adjNode.to, dijk[adjNode.to])); // 변경되면 pq에 추가
                }
            }
        }

        for (int i = 1; i < dijk.length; i++) {
            if (dijk[i] == Integer.MAX_VALUE){
                System.out.print("INF ");
            } else{
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
