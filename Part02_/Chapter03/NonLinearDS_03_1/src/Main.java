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

        if (this.head == null) {
            this.head = new Node(key, null, null);
        } else {
            Node cur = this.head;
            while(true) {
                Node pre = cur;
                if (cur.key > key) {
                    cur = cur.left;

                    if (cur == null) {
                        pre.left = new Node(key, null, null);
                        break;
                    }
                } else {
                    cur = cur.right;

                    if (cur == null) {
                        pre.right = new Node(key, null, null);
                        break;
                    }
                }
            }
        }
    }

    public void removeNode(int key) {
        Node parent = null; //부모노드 가리킬 애
        Node successor = null; //지울려고 하는 노드자리로 올려줄 후계자 (왼쪽 서브트리의 제일 큰 노드 or 오른 쪽 서브트리의 제일 작은 노드)
        Node predecessor = null; //후계자의 부모 가리킬 노드
        Node child = null; //successor의 자식노드 가리킬 노드

        Node cur = this.head;
        while (cur != null) {
            if (key == cur.key) {
                break;
            }

            parent = cur;
             if (cur.key > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (cur == null) {
            System.out.println("key에 해당하는 노드가 업슴");
            return;
        }
        if (cur.left == null && cur.right == null) { //자식이 하나도 없는 경우 Leaf 노드
            if (parent == null) { //노드 한 개였는데 삭제하는 경우
                this.head = null;
            } else {
                if (parent.left == cur) {
                    parent.left = null;
                }
                else {
                    parent.right = null;
                }
            }
        } else if ((cur.left == null && cur.right != null) || (cur.left != null && cur.right == null)) { //자식노드가 하나인 경우
            if (cur.left != null) {
                child = cur.left;
            } else {
                child = cur.right;
            }

            if (parent == null) { //삭제하려고 하는게 루트. 자식노드가 하나만 있던 경우
                this.head = child;
            } else {
                if (parent.left == cur) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }else { //자식이 둘인 경우
            predecessor = cur;
            successor = cur.left;
            while (successor.right != null) {
                predecessor = successor;
                successor = successor.right;
            }
            predecessor.right = successor.left;
            successor.left = cur.left;
            successor.right = cur.right;

            if (parent == null) {
                this.head = successor;
            } else {
                if (parent.left == cur) {
                    parent.left = successor;
                } else {
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
