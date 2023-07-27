// Practice 3
// 정수들을 힙 자료구조에 추가하고 n번 삭제 후 절대값이 큰 값부터 출력하세요.

// 입력: 3 0 -2 -5 9 6 -11, 20, -30
// 삭제 횟수: 1
// 출력: 20, -11 9 6 -5 3 -2 0

import java.util.ArrayList;
import java.util.stream.IntStream;

class Num {
    int val;
    boolean isMinus;

    public Num(int val) {
        this.isMinus = val < 0 ? true : false;
        this.val = Math.abs(val);
    }
}

class MaxHeap2 {
    ArrayList<Num> heap;

    public MaxHeap2() {
        this.heap = new ArrayList<>();
        this.heap.add(new Num(0));
    }

    public void insert(int data) {
        this.heap.add(new Num(data));

        int cur = this.heap.size() - 1;
        while(cur > 1 && this.heap.get(cur / 2).val < this.heap.get(cur).val) {
            Num parentVal = this.heap.get(cur / 2);
            this.heap.set(cur / 2, this.heap.get(cur));
            this.heap.set(cur , parentVal);

            cur /= 2;
        }
    }
    public Num delete() {
        if (this.heap.size() == 1) {
            System.out.println("Heap is Empty !");
            return null;
        }
        Num target = this.heap.get(1);

        this.heap.set(1, heap.get(this.heap.size() - 1));
        this.heap.remove(this.heap.size() - 1);

        int cur = 1;
        while(true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if(rightIdx < this.heap.size()) {
                targetIdx = this.heap.get(leftIdx).val > this.heap.get(rightIdx).val ? leftIdx : rightIdx;
            } else if(leftIdx < this.heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (this.heap.get(cur).val < this.heap.get(targetIdx).val) {
                Num parentVal = this.heap.get(cur);
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
public class Practice3 {
    public static void solution(int[] nums, int deleteCnt) {
        MaxHeap2 maxHeap = new MaxHeap2();
        IntStream.of(nums).forEach(x -> maxHeap.insert(x));

        int cnt = 0;
        while (maxHeap.heap.size() != 1) {
            Num cur = maxHeap.delete();

            if (cnt++ < deleteCnt) {
                continue;
            }

            int oriVal = cur.isMinus ? cur.val * -1 : cur.val;
            System.out.print(oriVal + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test code
        int nums[] = {3, 0, -2, -5, 9, 6, -11, 20, -30};
        int deleteCnt = 1;
        solution(nums, deleteCnt);
    }
}
