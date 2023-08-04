// 알고리즘 - 최단 경로 알고리즘
// 플로이드-워셜

public class Main {

    static int[][]dist;
    static final int INF = 1000000000;

    public static void floydWarshall(int v, int e, int[][] data, int start) {
        dist = new int[v + 1][v + 1];
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
            }
        }
        for (int i = 0; i < e; i++) {
            dist[data[i][0]][data[i][1]] = data[i][2]; //각 노드의 인접노드까지의 값이 업데이트
        }

        //플로이드 워셜로 각 정점을 지나갈 때의 업데이트
        for (int k = 1; k < v + 1; k++) {
            //i -> j (k를 거쳐서 가는 경우가 짧을 때 업데이트)
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (dist[i][j] >= INF) {
                    System.out.printf("%5s ", "INF");
                } else {
                    System.out.printf("%5s ", dist[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Test code
        int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
        System.out.println();

        data = new int[][]{{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, -5}, {6, 7, -7}};
        floydWarshall(7, 11, data, 1);
    }
}
