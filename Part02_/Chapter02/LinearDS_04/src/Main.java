// 선형 자료구조 - 연결 리스트
// 단순 연결 리스트 (simple ver.) 기본 구조 구현

// 노드
class Node {
    int data;
    Node next; //자기 자신 타입(Node를 가리킬 변수)

    Node(){}
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head; //맨처음 헤드 역할을 할 노드

    LinkedList(){}
    LinkedList(Node node){
        this.head = node;
    }

    //  연결 리스트 비어있는지 확인
    public boolean isEmpty(){
        if(this.head == null) {//연결리스트가 비어있다면 head가 아무것도 가리키지 않을 거임
            return true;
        }
        return false;
    }

    //  연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data){
        if( this.head == null ){ //헤드가 null이었으면
            this.head = new Node(data,null); //노드 하나 생성해서 data와 링크를 넣어주고 head에 할당을 해줌.
        }
        else{
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data,null);
        }
    }

    //  연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData(){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
         //head부터 순회
        Node cur = this.head;
        Node prev = cur;
        while(cur.next != null){
            prev = cur;
            cur = cur.next;
        }
        if(cur == this.head){
            this.head = null;
        } else{
            prev.next = null;
        }

    }

    //  연결 리스트에서 데이터 찾기
    public void findData(int data){
        if(isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            if(cur.data == data){
                System.out.println("Data exist !!!");
                break;
            }
            cur = cur.next;
        }

        System.out.println("Data not found");
    }

    //  연결 리스트의 모든 데이터 출력
    public void showData(){
        if(isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}


public class Main {

    public static void main(String[] args) {

//      Test Code
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();      // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();      // 1 2 3 4 5

        myList.findData(3);     // Data exist!
        myList.findData(100);   // Data not found!

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData();      // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData();    // List is empty

    }

}
