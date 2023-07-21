// Practice4
// 배열 arr 에서 peek 값 모두 출력

// 입출력 예시)
// arr: 3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11
// 결과: 3, 6, 5, 10, 11

import java.util.ArrayList;

public class Practice4 {
    public static void main(String[] args) {
        //peek값은 ? 양 옆의 수보다 큰 수
        int arr[] = {3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};
        ArrayList <Integer> list = new ArrayList();

        for (int i = 0; i < arr.length; i++) {
            if( i == 0 && arr[i] > arr[i + 1]){
                list.add(arr[i]);
            }else if(i < arr.length - 1 && arr[i - 1] < arr[i] && arr[i] > arr[i + 1]){
                list.add(arr[i]);
            }else if(i == arr.length -1 && arr[i - 1] < arr[i]){
                list.add(arr[i]);
            }
        }
        System.out.println(list);
    }

}
