// 알고리즘 - 최단 경로 알고리즘
// 벨만-포드

public class Main {
    static class Edge { //간선정보관리해줄 클래스
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void bellmanFord(int v, int e, int[][] data, int start) {
        Edge[] edge = new Edge[e];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }
        int []dist = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        boolean isMinusCycle = false;
        for (int i = 0; i < v + 1; i++) { //음수 사이클 체크를 위해 v + 1 까지 돌림
            for (int j = 0; j < e; j++) { //매번 돌릴 때마다 모든 간선 체크
                Edge cur = edge[j];

                if (dist[cur.from] == Integer.MAX_VALUE) { //출발노드의 거리가 INF였으면 의미 없으니까 continue
                    continue;
                }
                if (dist[cur.to] > dist[cur.from] + cur.weight) {
                    dist[cur.to] = dist[cur.from] + cur.weight;

                    if (i == v) { //i가 v일때 업데이트가 일어난 경우에는 음수사이클이 존재한다는 말
                        isMinusCycle = true;
                    }
                }
            }
        }

        System.out.println("음수 사이클 발생 : " + isMinusCycle);
        for (int i = 1; i < v + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(dist[i] + " ");
            }
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
