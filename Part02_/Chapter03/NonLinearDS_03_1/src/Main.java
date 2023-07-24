// 비선형 자료구조 - 이진 탐색 트리

import jdk.nashorn.internal.ir.JoinPredecessor;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    BinarySearchTree(int key) {
        this.head = new Node(key, null, null);
    }

    public void addNode(int key) {
        if(this.head == null){
            this.head = new Node(key, null, null);
        } else{
            Node cur = this.head;
            while(true){
                Node pre = cur;

                if(key < cur.key){
                    cur = cur.left;

                    if(cur == null){
                        pre.left = new Node(key, null, null);
                        break;
                    }
                } else{
                    cur = cur.right;

                    if(cur == null){
                        pre.right = new Node(key, null, null);
                        break;
                    }
                }
            }
        }

    }

    public void removeNode(int key) {
        Node parent = null;
        Node successor = null; //지울려는 노드의 자식 노드 중 후계자 찾을 변수
        Node predecessor = null; //지울려는 노드의 부모노드를 가리킬 변수
        Node child = null; //sucessor의 자식이 있는지 확인할 변수

        Node cur = this.head;
        while(cur != null){
            if(cur.key == key){ //cur에는 삭제하려는 노드 값
                break;
            }
            parent = cur; //삭제하려고 하는 노드의 부모노드 값을 가지고 있음
            if (key < cur.key){
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }
        if (cur == null){
            System.out.println("key에 해당하는 노드가 없습니다.");
            return;
        }
        if(cur.left == null && cur.right == null){ //삭제하려는 노드가 leaf노드
            if (parent == null){
                this.head = null;
            } else {
                if (parent.left == cur){
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if((cur.left != null && cur.right == null) || (cur.left == null && cur.right != null)){ //자식이 하나만 있으면
            if (cur.left != null){
                child = cur.left;
            } else{
                child = cur.right;
            }
            if (parent == null){ //루트노드에 자식노드가 하나만 있는 형태
                this.head = child;
            } else {
                if (parent.left == cur) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        } else { //자식 노드가 둘인 경우
            predecessor = cur;
            successor = cur.left; //삭제할 노드의 왼쪽 서브트리에서 가장 큰 값을 찾을 거임.

            while(successor.right != null){
                predecessor = successor;
                successor = successor.right; //후계자 선택
            }
            predecessor.right = successor.left; //successor의 right는 없음 있었으면 위에서 successor이 됐을 거임
            //아무튼 얘는 위로 올라갈 거니까 얘의 왼쪽 자식노드를 부모노드의 오른 쪽에 붙여줌
            successor.left = cur.left;
            successor.right = cur.right;

            if (parent == null){ //루트노드이면ㅁ서 자식노드가 두 개인 경우
                this.head = successor;
            } else{
                if (parent.left == cur){
                    parent.left = successor;
                } else{
                    parent.right = successor;
                }
            }
        }
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


public class Main {
    public static void main(String[] args) {
        // Test code
        // 노드 삽입
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(33);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);

        // 노드 삭제
        bst.removeNode(40);
        bst.levelOrder(bst.head);
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);
    }
}
