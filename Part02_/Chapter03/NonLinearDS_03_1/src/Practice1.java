// Practice1
// 앞의 BST 삽입, 삭제 코드를 재귀 형태로 구현

import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree2 {
    Node head;

    BinarySearchTree2(int key) {
        this.head = new Node(key, null, null);
    }

    public Node addNodeRecursive(Node cur, int key) {
        if (cur == null){
            return new Node(key, null, null);
        }
        if (key < cur.key) {
            cur.left = addNodeRecursive(cur.left, key);
        } else{
            cur.right = addNodeRecursive(cur.right, key);
        }
        return cur;
    }

    public Node removeNodeRecursive(Node cur, int key) {
        if(cur == null){
            return null;
        }
        if (key < cur.key){
            cur.left = removeNodeRecursive(cur.left, key);
        } else if (key > cur.key){
            cur.right = removeNodeRecursive(cur.right, key);
        } else {//삭제하려고 하는 노드를 찾은 케이스
            //자식노드가 하나이거나 없는 경우
            if (cur.left == null){
                return cur.right; //삭제하려는 노드의 왼쪽 자식이 없는 경우 오른쪽 자식노드 리턴
            } else if (cur.right == null){
                return cur.left;
            } else{ //자식노드가 둘인 경우
                Node predecessor = cur;
                Node successor = cur.left;

                while(successor.right != null){
                    predecessor = successor;
                    successor = successor.right;
                }
                predecessor.right = successor.left;
                cur.key = successor.key; //오 링크 연결을 다시 해주는게 아니라 해당 노드 자리에 데이터만 바꿔 줌 !!
            }
        }
        return cur;
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }

}


public class Practice1 {
    public static void main(String[] args) {
        // Test code
        // 노드 삽입
        BinarySearchTree2 bst = new BinarySearchTree2(20);
        bst.head = bst.addNodeRecursive(bst.head, 10);
        bst.head = bst.addNodeRecursive(bst.head, 30);
        bst.head = bst.addNodeRecursive(bst.head, 1);
        bst.head = bst.addNodeRecursive(bst.head, 15);
        bst.head = bst.addNodeRecursive(bst.head, 25);
        bst.head = bst.addNodeRecursive(bst.head, 13);
        bst.head = bst.addNodeRecursive(bst.head, 35);
        bst.head = bst.addNodeRecursive(bst.head, 27);
        bst.head = bst.addNodeRecursive(bst.head, 40);
        bst.levelOrder(bst.head);

        // 노드 삭제
        bst.head = bst.removeNodeRecursive(bst.head,40);
        bst.levelOrder(bst.head);
        bst.head = bst.removeNodeRecursive(bst.head, 25);
        bst.levelOrder(bst.head);
        bst.head = bst.removeNodeRecursive(bst.head, 20);
        bst.levelOrder(bst.head);
    }
}
