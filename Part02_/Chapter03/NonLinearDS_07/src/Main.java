// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

import java.util.ArrayList;

class MinHeap {
    ArrayList <Integer> heap;

    public MinHeap(){
        this.heap = new ArrayList<>();
        this.heap.add(0); //더미데이터 하나 넣어서 인덱스 기준 1부터 시작할 수 있게 함.
    }
    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1;
        while (cur > 1 && heap.get(cur) < heap.get(cur / 2)) {
            int parent = this.heap.get(cur / 2);
            this.heap.set(cur / 2, data);
            this.heap.set(cur ,parent);

            cur /= 2;
        }
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is Empty!");
            return null;
        }
        int target = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int cur = 1;
        while (true) {
            int left = cur * 2;
            int right = cur * 2 + 1;
            int targetIdx = -1;

            if (right < this.heap.size()) { //자식 두 개 중 작은 거 골라야함
                targetIdx = heap.get(left) < heap.get(right) ? left : right;
            }else if (left < this.heap.size()) {
                targetIdx = cur * 2;
            } else {
                break;
            }
            if (this.heap.get(targetIdx) < this.heap.get(cur)) {
                int parentVal = this.heap.get(cur);
                this.heap.set(cur, this.heap.get(targetIdx));
                this.heap.set(targetIdx, parentVal);

                cur = targetIdx;
            } else {
                break;
            }
        }
        return target;
    }
}
public class Main {
    public static void main(String[] args) {
        // Test code
        MinHeap minHeap = new MinHeap();
        System.out.println("== 데이터 삽입 ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제: " + minHeap.delete());
        minHeap.printTree();
    }
}
