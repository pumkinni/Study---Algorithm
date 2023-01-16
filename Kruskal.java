// 크루스칼 알고리즘

import java.util.Arrays;

public class Kruskal {
    static int[] parent;

    public static int kruskal(int[][] data, int v, int e) {
        int weightSum = 0;
        // 가중치 기준 오름차순 정렬
        Arrays.sort(data, (x,y) -> x[2] - y[2]);
        // 사이클 확인 메모리 생성
        parent = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            parent[i] = i;
        }

        // 가중치가 작은 간선부터 사이클 확인하며 합치기
        for (int i = 0; i < e; i++) {
            if (find(data[i][0]) != find(data[i][1])){
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
            }
        }

        return weightSum;
    }

    public static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);

        if (aP != bP){
            parent[bP] = aP;
        }
    }

    // parent 노드 찾고 업데이트
    public static int find(int a){

        if (parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};

        System.out.println(kruskal(graph, v, e));
    }
}
