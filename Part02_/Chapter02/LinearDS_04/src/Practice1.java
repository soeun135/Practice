// Practice1
// 단순 연결 리스트 구현 완성

class Node1{
    int data;
    Node next;

    Node1(){}
    Node1(int data,Node next){
        this.data = data;
        this.next = next;
    }
}

class LinkedList1 extends LinkedList{
    LinkedList1(Node node){
        this.head = node; //LL1에 head가 없으니까 부모클래스의 head의미 this.대신 super.로 해도 동일하다
    }
    //연결리스트에 데이터 추가 (중간에 데이터 추가)
    //before_data가 null인 경우, 가장 뒤에 추가
    //before_data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data,Integer before_data){
        if(this.head == null){ //헤드에 아무 것도 없는 경우
            this.head = new Node(data,null); //Node 새로 만들어서 head가 가리키게 함
        }
        else if(before_data == null){ //맨 뒤에 값 추가
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data,null);
        }
        else { //중간에 값 추가
            Node cur = this.head;
            Node prev = cur;

            while(cur != null) {
                if (cur.data == before_data) { //그 앞에 끼워넣어야 함
                    if (cur == this.head) {
                        this.head = new Node(data, this.head); //주의 !! 새로운 노드의 다음노드는 헤드가 가리키고 있는 거라서 this.head로만 넣어준 거임 !
                    } else {
                         prev.next= new Node(data, cur);
                         //주의 !! prev의 next == 현재 prev가 가리키고있는 곳 다음에 새로만든 Node끼워넣을 거니까
                        //그리고 새로만들어진 Node의 next는 cur이 가리키고 있는 노드 !!
                    }
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }
    //연결리스트에 데이터 삭제
    public void removeData(int data){
        if(this.isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        Node cur = this.head;
        Node prev = cur;
        while(cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}

public class Practice1 {
    public static void main(String[] args) {

//      Test code
        LinkedList1 myList = new LinkedList1(new Node(1, null));
        myList.showData();         // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData();         // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();         // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();         // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();         // List is empty!
    }
}
