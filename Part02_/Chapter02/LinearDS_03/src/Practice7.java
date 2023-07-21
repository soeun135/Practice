// Practice7
// 2차원 배열 arr 을 시계방향 90도 회전시킨 결과를 출력하세요.

// 입출력 예시:
// arr:
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15
// 결과:
// 11 6 1
// 12 7 2
// 13 8 3
// 14 9 4
// 15 10 5


public class Practice7 {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
            //내풀이
//         for (int j = 0; j < arr[0].length; j++){
//            for (int i = arr.length-1; i >=0 ; i--){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        //강사님 풀이
        int arr90[][] = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j  = 0; j < arr[i].length; j++) {
                int r = arr.length -1 -i;
                arr90[j][r] = arr[i][j];
            }
        }
        for(int x[] : arr90){
            for(int y : x){
                System.out.print(y+" ");
            }
            System.out.println();
        }

    }
}
