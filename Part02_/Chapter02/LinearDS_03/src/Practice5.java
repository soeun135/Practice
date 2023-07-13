// Practice5
// 배열 arr 의 값을 오름차순으로 출력

// 입출력 예시)
// arr: 5, 3, 1, 4, 6, 1
// 결과: 1, 1, 3, 4, 5, 6

import java.util.Arrays;

public class Practice5 {
    public static void main(String[] args) {
        int arr[] = {5,3,1,4,6,1};
       // Arrays.sort(arr);
        int []visited = new int[arr.length];
        int visitedCnt = 0;
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        while(visitedCnt < arr.length){
            for (int i = 0; i < arr.length ; i++) {
                if(arr[i] < minVal && visited[i] == 0){ //배열을 돌면서 가장 작은 값을 찾아줄 거임
                    minVal = arr[i];
                    minIdx = i;
                }
            }
            if(minIdx != -1){
                System.out.print(minVal+" ");
                visited[minIdx] = 1;
                visitedCnt++;
            }
            minVal = Integer.MAX_VALUE;
            minIdx = -1;
        }
        System.out.println();

        //내풀이
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[i] > arr[j]){
//                    int tmp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = tmp;
//                }
//            }
//        }
//        for(int x : arr)
//        System.out.print(x+" ");
    }
}
