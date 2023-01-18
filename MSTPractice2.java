// 크러스칼 알고리즘을 통해 최소 신장 트리를 만들고 가장 큰 비용의 도로를 제외시킨다.

import java.util.Arrays;


public class MSTPractice2 {
    static int[] parent;

    public static void solution(int v, int e, int[][] data){
        int weightSum = 0;
        int weightMax = -100000000;

        Arrays.sort(data, (x,y) -> x[2] - y[2]);

        parent = new int[v+1];
        for (int i = 0; i < v+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            if (find(data[i][0]) != find(data[i][1])){
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
                weightMax = Math.max(weightMax, data[i][2]);
            }
        }
        System.out.println(weightSum-weightMax);
    }

    public static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);

        if (aP != bP){
            parent[aP] = bP;
        }
    }

    public static int find(int a){
        if (a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 12;
        int[][] data = {{1, 2, 3}, {1, 3, 2}, {1, 6, 2}, {2, 5, 2},
                {3, 2, 1}, {3, 4, 4}, {4, 5, 3}, {5, 1, 5},
                {6, 4, 1}, {6, 5, 3}, {6, 7, 4}, {7, 3, 6}};
        solution(v, e, data);
    }
}
