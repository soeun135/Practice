// Practice
// ArrayList를 사용한 집합 구현 실습 (집합 관련 연산 사용 X)

import java.util.ArrayList;
import java.util.Arrays;

class MySet {
// ArrayList
    ArrayList<Integer> list;

// 생성자1
    public MySet(){
        this.list = new ArrayList<Integer>();
    }

// 생성자 2
    public MySet(int arr[]){
        this.list = new ArrayList<Integer>();

        for (int x: arr) {
            this.list.add(x);
        }
    }

// 원소 추가 (중복 X)
    public void add(int x){
        for(int items : this.list){
            if(items == x) return;
        }
        this.list.add(x);
    }

// 교집합
    public MySet retainAll(MySet b){
        MySet result = new MySet();
        for(int itemsA : this.list){
            for(int itemsB : b.list){
                if(itemsA == itemsB){ //두 집합의 공통된 원소만 result에 add
                    result.add(itemsA);
                }
            }
        }
        return result;
    }

// 합집합
    public MySet addAll(MySet b){
        MySet result = new MySet();
        for(int itemsA : this.list){
            result.add(itemsA);
        }
        for(int itemsB : b.list){
            result.add(itemsB);
        }//add메소드에서 어차피 중복은 걸러짐.
        return result;
    }

// 차집합
    public MySet removeAll(MySet b){
        MySet result = new MySet();

        for(int itemsA : this.list) {
            boolean containFlag = false;
            for (int itemsB : b.list) {
                if (itemsA == itemsB) {
                    containFlag = true;
                    break;
                }
            }
            if(!containFlag)
                result.add(itemsA);
        }
        return result;
    }

}

public class Practice {
    public static void main(String[] args) {

//      Test code
        MySet a = new MySet();

        a.add(1);
        a.add(1);
        a.add(1);
        System.out.println(a.list);
        a.add(2);
        a.add(3);
        System.out.println(a.list);

        a = new MySet(new int[]{1, 2, 3, 4, 5});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10});
        System.out.println("a 실스읍: " + a.list);
        System.out.println("b: " + b.list);

        MySet result = a.retainAll(b);
        System.out.println("교집합: " + result.list);

        result = a.addAll(b);
        System.out.println("합집합: " + result.list);

        result = a.removeAll(b);
        System.out.println("차집합: " + result.list);
    }
}
