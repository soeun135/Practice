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
        this.heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur) > heap.get(cur/2)) {
            int parentVal = heap.get(cur/2);
            heap.set(cur/2, data);
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is Empty !");
            return null;
        }
        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int cur = 1;
        while(true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = -1;

            if (right < heap.size()) {
                targetIdx = heap.get(left) > heap.get(right) ? left : right;
            } else if (left < heap.size()) {
                targetIdx = left;
            } else {
                break;
            }

            if (heap.get(targetIdx) > heap.get(cur)) {
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
