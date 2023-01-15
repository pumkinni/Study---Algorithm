// 무방향 가중치 그래프에서 2개의 노드를 거쳐가는 최단 거리 구하기

// 다익스트라 방법으로 풀어보기


import java.util.ArrayList;
import java.util.PriorityQueue;

public class SPPractice1_1 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Node>> graph;
    static final int INF = 100000000;

    public static int solution(int[][] data, int v, int via1, int via2, int start, int n) {

        // 그래프 생성
        graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
            graph.get(data[i][1]).add(new Node(data[i][0], data[i][2]));
        }

        int p1 = 0;
        int p2 = 0;
        p1 += dijkstra(v, start, via1);
        p1 += dijkstra(v, via1, via2);
        p1 += dijkstra(v, via2, n);


        p2 += dijkstra(v, start, via2);
        p2 += dijkstra(v, via2, via1);
        p2 += dijkstra(v, via1, n);

        if (p1 >= INF && p1 >= INF){
            return -1;
        }

        return Math.min(p1,p2);
    }

    public static int dijkstra(int v, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> (x.weight - y.weight));
        pq.offer(new Node(start, 0));

        // 최단 거리 메모리 초기화
        int[] dist = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        boolean[] visited = new boolean[v+1];

        while (!pq.isEmpty()){
            Node curNode = pq.poll();

            if (visited[curNode.to]){
                continue;
            }
            visited[curNode.to] = true;

            ArrayList<Node> adjNodes = graph.get(curNode.to);
            // 인접 노드 최단거리 갱신
            for (int i = 0; i < adjNodes.size(); i++) {
                Node adjNode = adjNodes.get(i);
                if (!visited[adjNode.to] && dist[adjNode.to] > curNode.weight + adjNode.weight){
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }
        return dist[end];
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
