// Practice 1
// ArrayList 로 최대 힙 구현

import java.util.ArrayList;

class MaxHeap {
    ArrayList<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1; //현재 새로 추가한 노드의 인덱스
        while(cur > 1 && heap.get(cur / 2) < heap.get(cur)) {//부모보다 자식이 크면
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if (this.heap.size() == 1) {
            System.out.println("Heap is Empty !");
            return null;
        }
        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while(true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < heap.size()) { //왼쪽 오른쪽 자식이 모두 존재
                targetIdx = heap.get(leftIdx) > heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) { //자식이 하나만 존재
                targetIdx = leftIdx;
            } else { //자식이 없는 경우
                break;
            }
            if(heap.get(cur) < heap.get(targetIdx)) {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            } else {
                break;
            }
        }
        return target;
    }

    public void printTree() {
        for (int i = 1; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

}
public class Practice1 {

    public static void main(String[] args) {
        // Test code
        MaxHeap maxHeap = new MaxHeap();
        System.out.println("== 데이터 삽입 ==");
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(10);
        maxHeap.printTree();
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.printTree();
        maxHeap.insert(20);
        maxHeap.printTree();
        maxHeap.insert(30);
        maxHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
        System.out.println("삭제: " + maxHeap.delete());
        maxHeap.printTree();
    }
}
