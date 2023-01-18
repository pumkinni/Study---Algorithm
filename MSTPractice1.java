
// 프림 알고리즘을 이용하여 최소 신장트리 구하기
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MSTPractice1 {
    public static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int solution(int[][] data) {
        int weightSum = 0;
        int v = data.length;
        // 그래프 생성
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i==j){
                    continue;
                }
                int weight = Math.min(Math.abs(data[i][0]- data[j][0]),Math.abs(data[i][1]- data[j][1]));
                weight = Math.min(weight, Math.abs(data[i][2]- data[j][2]));
                graph.get(i+1).add(new Node(j+1, weight));
            }
        }

        boolean[] visited = new boolean[v+1];
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);

        pq.offer(new Node(1,0));
        int cnt=0;
        while (!pq.isEmpty()){
            Node curNode = pq.poll();
            if (visited[curNode.to]){
                continue;
            }
            visited[curNode.to] = true;
            cnt ++;
            weightSum += curNode.weight;
            if (cnt == v){
                return weightSum;
            }

            // 인접 노드 확인 후 추가
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);
                if (visited[adjNode.to]){
                    continue;
                }
                pq.offer(new Node(adjNode.to, adjNode.weight));
            }
        }

        return weightSum;
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{11, -15, -15}, {14, -5, -15}, {-1, -1, -5}, {10, -4, -1}, {19, -4, 19}};
        System.out.println(solution(data));
    }
}
