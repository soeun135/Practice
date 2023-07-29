// Practice3
// 트리 구조 복습 / 구현

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    char data;
    Node2 left;
    Node2 right;
    Node2 parent;

    public Node2(char data, Node2 left, Node2 right, Node2 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class BinaryTree3 {
    Node2 head;

    public BinaryTree3(char[] arr) {
        Node2 nodes[] = new Node2[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node2(arr[i], null, null, null);
        }
        for (int i = 0; i < arr.length; i++) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i];
            }
            if (right < arr.length) {
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Node2 searchNode(char c) {
        Queue<Node2> q = new LinkedList<>();
        q.offer(this.head);
        while (!q.isEmpty()) {
            Node2 cur = q.poll();
            if (cur.data == c) {
                return cur;
            }
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
        return null;
    }

    public Integer checkSize(char data) { //data 해당하는 노드로부터 사이즈 체크해서 반환
        Node2 node = this.searchNode(data);

        Queue <Node2> q = new LinkedList<>();
        q.offer(node);
        int cnt = 0;
        while (!q.isEmpty()) {
            Node2 cur = q.poll();
            if (cur.left != null) {
                q.offer(cur.left);
                cnt ++;
            }
            if (cur.right != null) {
                q.offer(cur.right);
                cnt ++;
            }
        }
        return cnt + 1;
    }
}

public class Practice3 {

    public static void main(String[] args) {
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);

        // Root node
        System.out.println("Root Node : " + bt.head.data);

        // B's child node
        Node2 B = bt.searchNode('B');
        if (B.left != null) {
            System.out.println("B's left Node : " + B.left.data);
        }
        if (B.right != null) {
            System.out.println("B's right Node : " + B.right.data);
        }
        // F's parent node
        Node2 F = bt.searchNode('F');
        System.out.println("F's parent node : " + F.parent.data);

        // Leaf node 자식이 없는 노드
        System.out.print("Leaf node : ");
        for (int i = 0; i < arr.length; i++) {
            Node2 cur = bt.searchNode((char)(i+'A'));

            if (cur.left == null && cur.right == null) {
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();

        // E's Depth
        Node2 E = bt.searchNode('E');
        Node2 cur = E;
        int cnt = 0;
        while (cur.parent != null) {
            cnt++;
            cur = cur.parent;
        }
        System.out.println("E depth : " + cnt);

        // Level2 Node
        System.out.print("Level2 node : ");
        for (int i = 0; i < arr.length ; i++) {
            Node2 target = bt.searchNode((char)(i+'A'));
            cur = target;
            cnt = 0;
            while (cur.parent != null) {
                cnt++;
                cur = cur.parent;
            }
                if (cnt == 2) {
                    System.out.print(target.data + " ");
                }
            }
            System.out.println();

        // Height
        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt.searchNode((char)('A' + i));
            cur = target;
            cnt = 0;
            while(cur.parent != null) {
                cur = cur.parent;
                cnt ++;
            }

            if (cnt > maxCnt) {
                maxCnt = cnt;
            }
        }
        System.out.println("Tree's height : " + maxCnt);


        // B's Size
        int size = bt.checkSize('B');
        System.out.println("B size= " + size);
    }
}
