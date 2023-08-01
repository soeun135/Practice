// 힙 정렬

import java.util.Arrays;

public class Main2 {
    
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0 ; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }

    }

    public static void heapify(int[] arr, int parentIdx, int size) { //힙구조로 바꿔주는 부분
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx; //max자료 찾아서 자식이랑 비교해서 큰 값을 앞으로 댕겨옴

        if (leftIdx < size && arr[maxIdx] < arr[leftIdx]) {
            maxIdx = leftIdx;
        }
        if (rightIdx < size && arr[maxIdx] < arr[rightIdx]) {
            maxIdx = rightIdx;
        }
        if (parentIdx != maxIdx) {
            swap(arr, maxIdx, parentIdx);
            heapify(arr, maxIdx, size);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
