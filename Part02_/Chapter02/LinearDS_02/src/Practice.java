// Practice
// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현

import java.util.Arrays;

class MyArray {

    int[] arr;

//  배열의 초기 사이즈 설정
    public MyArray(int size){
        this.arr = new int[size];
    }

//  배열에 데이터 삽입
    public void insertData(int idx, int num){
        if(idx < 0 || idx > this.arr.length) {
            System.out.println("Index error");
            return;
        }
        int[] arrDup = this.arr.clone(); //기존 배열 데이터들을 복사
        this.arr = new int[this.arr.length+1];
        for (int i = 0; i < idx; i++) {
            this.arr[i] = arrDup[i]; //기존 데이터 인덱스까지 넣어줌
        }
        for (int i = idx+1; i < this.arr.length; i++) {
            arr[i] = arrDup[i-1];
        }
        this.arr[idx] = num;
    }

//  배열에서 특정 데이터 삭제
    public void removeData(int data){
        int targetIndex = -1;
        for(int i : arr){
            if( i == data ){
                targetIndex = i;
                break;
            }
        }
        if(targetIndex == -1){
            System.out.println("해당 데이터가 없습니다.");
            return;
        }
        else{
            int []arrDup = this.arr.clone();
            this.arr = new int[this.arr.length-1];
            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];
            }
            for (int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i+1];
            }
        }

    }
}

public class Practice {
    public static void main(String[] args) {

//      Test code
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));   // [1, 2, 3, 4, 5]

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 3, 4, 5]

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5]

        myArray.insertData(6, 60);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5, 60]

        myArray.insertData(-1, 0);  // Index Error

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 5, 60]

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 60]

        myArray.removeData(99); // 해당 데이터가 없습니다.
    }
}