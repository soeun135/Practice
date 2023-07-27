// 비선형자료구조 - 힙
// ArrayList 로 최소 힙 구현

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0); //인덱스 기준으로 1번부터 시작할 수 있도록 맨 처음 데이터를 넣어줌
    }

    public void insert(int data) {
        heap.add(data);

        //부모 키 ur값과 새로 들어간 노드 값 비교
        int cur = heap.size() - 1; //방금 넣은 데이터의 인덱스 위치
        while(cur > 1 && heap.get(cur / 2) > heap.get(cur)) {
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data); //더 작은 값이 위로 갈 수 있게 값을 바꿔줌.
            heap.set(cur, parentVal);

            cur /= 2;
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is empty !");
            return null;
        }
        int target = this.heap.get(1);

        this.heap.set(1, this.heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) { //오른쪽 인덱스가 heap의 크기 안에 있다는 거는 왼쪽, 오른쪽 자식노드 모두 존재한다는 것
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if(leftIdx < heap.size()) {
                targetIdx = leftIdx;
            } else { //자식노드가 없는 상황, 단말노드인 상황
                break;
            }
            if (heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }
        return target;
    }
    public void printTree() {
        for (int i = 1; i < this.heap.size() ; i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
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
