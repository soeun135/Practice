import java.util.Arrays;

public class Practice2 {
    public static void solution(int[] arr) {
        //원래 수
        int tenMulti = (int)Math.pow(10,arr.length-1);
        int originNum = 0;
        boolean answerFlag = false;
        for(int x : arr){
            originNum += x*tenMulti;
            tenMulti /= 10;
        }
        int depth = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            swap(arr,depth,depth-i);
            tenMulti = (int)Math.pow(10,arr.length-1);
            int tmpNum = 0;
            for(int x : arr){
                tmpNum += x*tenMulti;
                tenMulti /= 10;
            }
            if(originNum > tmpNum){
                System.out.println(tmpNum);
                answerFlag = true;
                break;
            }
        }
        if(!answerFlag) System.out.println(originNum);

    }
    public static void swap(int []arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
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
