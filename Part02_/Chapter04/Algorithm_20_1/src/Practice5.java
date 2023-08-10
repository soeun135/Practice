import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Practice5 {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
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
    static int[] parents;
    static ArrayList<Edge> edgeList;
    public static int solution(int n, int m, int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            return -1;
        }
        edgeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            edgeList.add(new Edge(data[i][0], data[i][1], data[i][2]));
        }
        //최악 경로 (오르막길 0기준 sorting) ->오름차순 정렬
        Collections.sort(edgeList, (x, y) -> x.weight - y.weight);
        int worst = kruskal(edgeList, n);

        //최적 경로
        Collections.sort(edgeList, (x, y) -> y.weight - x.weight);
        int best = kruskal(edgeList, n);
        return worst * worst - best * best;
    }

    public static int kruskal(ArrayList <Edge>list,int n) {
        parents = new int[n + 1];
        for (int i = 0; i < n + 1 ; i++) {
            parents[i] = i;
        }
        int weightSum = 0;
        for (int i = 0; i < list.size(); i++) {
            Edge edge = list.get(i);

            if (find(edge.from) != find(edge.to)) {
                union(edge.to, edge.from);
                if (edge.weight == 0) {
                    weightSum ++; //오르막길을 오른 카운트
                }
            }
        }
        return weightSum;
    }

    public static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[bP] = aP;
        }
    }

    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int m = 5;
        int[][] data = {{1, 2, 0}, {1, 4, 0}, {2, 3, 0}, {3, 4, 1}, {4, 2, 1}};

        System.out.println(solution(n, m, data));
    }
}
