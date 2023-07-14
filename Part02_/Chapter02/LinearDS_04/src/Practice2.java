// Practice2
// 양방향 연결 리스트 (Doubly Linked List) 구현

class NodeBi {
    int data;
    NodeBi next;
    NodeBi prev;

    NodeBi(){}
    NodeBi(int data, NodeBi next, NodeBi prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList extends LinkedList{
    NodeBi head;
    NodeBi tail;
    DoublyLinkedList(){}
    DoublyLinkedList(NodeBi node){ //노드가 만들어져서 객체가 생성되는 경우 처음엔 head와 tail이 같은 노드를 가리키게 함.
        this.head = node;
        this.tail = node;
    }
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

    public void addData(int data,Integer beforeData){
        if(this.head == null){ //노드가 아무것도 없었을 때 head가 새로생긴 노드, tail도 head가 가리키고 있는 거 가리길 수있게 함
            this.head = new NodeBi(data,null,null);
            this.tail = this.head;
        }
        else if(beforeData == null){ //가장 끝에 값 추가
            this.tail.next = new NodeBi(data,null,this.tail);
            this.tail = this.tail.next;
        }
        else{ //beforeData가 있는 경우
            NodeBi cur = this.head;
            NodeBi prev = cur;
            while( cur != null){
                if(cur.data == beforeData){
                    if(cur == this.head){
                        this.head = new NodeBi(data,this.head,null);//새로 만들어진 노드와 헤드의 연결
                        this.head.next.prev = this.head; //원래 있던 노드와 새로 만들어진 노드의 연결
                    }
                    else{
                        prev.next = new NodeBi(data,cur,prev); //새로만들어진 노드와 이전 노드의 연결
                        cur.prev = prev.next;
                    }
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data){
        if(isEmpty()){
            System.out.println("List is Empty !");
            return;
        }
        NodeBi cur = this.head;
        NodeBi prev = cur;

        while(cur != null){
            if(cur.data == data){
                if(cur == this.head && cur == this.tail){ //노드가 하나인 케이스
                    this.head = null;
                    this.tail = null;
                }
                else if(cur == this.head){//첫 번째 노드를 삭제하는 경우
                    this.head = cur.next;
                    this.head.prev = null;
                }
                else if(cur == this.tail){//제일 끝 노드를 삭제하는 경우
                    //강사님 방법
//                    this.tail = this.tail.prev;
//                    this.tail.next = null;

                    //내 방법
                    prev.next = null;
                    this.tail = cur.prev;
                    cur.prev = null;

                    //여기를 tail말고 cur이나 prev이용해서 해주면 안되나 ??
                    //되는데 강사님 방법이 훨씬 간단함
                }
                else{
                    prev.next = cur.next;
                    cur.next.prev = prev;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }
    public void showData(){
        if(isEmpty()){
            System.out.println("List isEmpty");
            return;
        }
        NodeBi cur = this.head;

        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void showDataFromTail(){ //역순 출력
        if(isEmpty()){
            System.out.println("List is EEmpty");
            return;
        }
        NodeBi cur = this.tail;

        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.prev;
        }
        System.out.println();
    }
}



public class Practice2 {
    public static void main(String[] args) {

//      Test code
        DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
        myList.showData();          // 1
//
        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail();  // 5 4 3 2 1
//
        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();          // 100 1 200 2 300 3 400 4 500 5
        myList.showDataFromTail();  // 5 500 4 400 3 300 2 200 1 100
//
        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 5
        myList.showDataFromTail();  // 5 4 3 2 1
//
        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // List is empty!
        myList.showDataFromTail();  // List is empty!
    }
}
