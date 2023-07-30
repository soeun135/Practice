import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Practice3
// 인접 리스트 그래프의 DFS, BFS
class MyGraphList2 extends MyGraphList{
    public MyGraphList2(int size) {
        super(size);
    }
    public void dfs(int id) {
        //배열, 스택으로 구현
        Stack <Integer> stack = new Stack<>();
        boolean visited[] = new boolean[this.elemCnt];

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();

            System.out.print(this.vertices[curId] + " ");

            Node cur = this.adjList[curId];
            while (cur != null) {
                if (!visited[cur.id]) {
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }

    public void bfs(int id) {
        Queue <Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[this.elemCnt];

        q.offer(id);
        visited[id] = true;

        while(!q.isEmpty()) {
            int curId = q.poll();
            System.out.print(this.vertices[curId] + " ");

            Node cur = this.adjList[curId];
            while(cur != null) {
                if (!visited[cur.id]) {
                    q.offer(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println(  );
    }
}


public class Practice3 {
    public static void main(String[] args) {
        // Test code
        MyGraphList2 graph = new MyGraphList2(7);
        graph.addVertex('A');   // 0
        graph.addVertex('B');   // 1
        graph.addVertex('C');   // 2
        graph.addVertex('D');   // 3
        graph.addVertex('E');   // 4
        graph.addVertex('F');   // 5
        graph.addVertex('G');   // 6

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.dfs(0);
        graph.bfs(0);
    }
}
