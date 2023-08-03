import java.util.ArrayList;
import java.util.PriorityQueue;

// 다익스트라 우선순위 큐 사용
public class Main2 {
    static class Node {
        int to; //해당 노드에서
        int weight; //어떤 노드로 weight만큼의 비용이 든다.

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

    public static void dijkstra(int v, int[][] data, int start) {
        ArrayList <ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length ; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }
        int dist[] = new int[v + 1];

        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue <Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);//weight 기준 minheap으로 pq구성
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size() ; i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }


        //출력부분
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
        int[][] data = {{1, 2, 2}, {1, 3, 3}, {2, 3, 4}, {2, 4, 5}, {3, 4, 6}, {5, 1, 1}};
        dijkstra(5, data, 1);
    }
}
