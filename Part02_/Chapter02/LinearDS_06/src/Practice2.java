// Practice2
// 배열을 이용한 기본 스택 직접 구현

class MyStack2 {
    int[] arr;
    int top = -1;

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        if(this.top == -1){
            return true;
        }else
        return false;
    }

    public boolean isFull() { //stack이나 ArrayList는 사이즈가 고정 되어있지 않아서 상관 X 배열은 사이즈 고정되어있으니까 가득 찼는지 check
        if(this.top == this.arr.length-1){
            return true;
        }else{
            return false;
        }
    }

    public void push(int data) {
        if(this.isFull()){
            System.out.println("Stack is full!");
            return;
        }
        this.top+=1;
        this.arr[this.top] = data;
    }

    public Integer pop() {
        if(this.isEmpty()){
            System.out.println("Stack is emptyl!");
            return null;
        }
        int data = this.arr[this.top];
        this.top-=1;//array에 데이터가 남아있긴 한데 top을 이용해서 접근할 수 없으니까 정상동작함
        return data;
    }

    public Integer peek() {
        if(this.isEmpty()){
            System.out.println("Stack is emptyl!");
            return null;
        }
        return this.arr[this.top];
    }

    public void printStack() {
        for (int i = 0; i <= this.top; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyStack2 myStack = new MyStack2(5);
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.printStack();               // 1, 2, 3, 4, 5

        System.out.println(myStack.peek()); // 5
        myStack.printStack();               // 1, 2, 3, 4, 5

        System.out.println(myStack.pop());  // 5
        System.out.println(myStack.pop());  // 4
        myStack.printStack();               // 1, 2, 3

        System.out.println(myStack.pop());  // 3
        System.out.println(myStack.pop());  // 2
        System.out.println(myStack.pop());  // 1
        myStack.printStack();
    }
}
