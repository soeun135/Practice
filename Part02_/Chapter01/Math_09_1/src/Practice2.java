import java.util.Arrays;

public class Practice2 {
    public static void solution(int[] arr) {
        boolean flag = false;
        if(arr == null || arr.length < 2){
            return;
        }

        int idx = -1;
        for (int i = arr.length - 1; i >= 1 ; i--) {
            if (arr[i] < arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        if(idx == -1) { //오른 쪽 수보다 큰 수를 찾지 못합.
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = arr.length -1 ; i > idx ; i--) {
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) {
                swap(arr, i, idx);
                break;
            }
        }
        System.out.println("메롱"+Arrays.toString(arr));
    }
    public static void swap(int []arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 2, 1};
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6};
        solution(arr);

        arr = new int[]{1, 1, 2, 3};
        solution(arr);
    }
}
