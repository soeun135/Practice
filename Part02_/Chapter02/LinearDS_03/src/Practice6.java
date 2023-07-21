// Practice6
// 배열 arr 에서 중복 값을 제거한 새 배열을 만드시오.

// 입출력 예시)
// arr: 1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5
// 결과: 1, 5, 3, 2, 4

import java.util.ArrayList;

public class Practice6 {
    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        ArrayList <Integer>list = new ArrayList();

        for(int i : arr){
            if(!list.contains(i)){
                list.add(i);
            }
        }
        System.out.println(list);
        int newArr[] = list.stream().mapToInt(x->x).toArray();

        for(int i : newArr){
            System.out.print(i + " ");
        }
    }
}
