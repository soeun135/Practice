// 알고리즘 - 정렬_2
// 합병 정렬

import java.util.Arrays;

public class Main {
    
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {

    }

    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {

    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
        System.out.println("합병 정렬: " + Arrays.toString(arr));
    }
}
