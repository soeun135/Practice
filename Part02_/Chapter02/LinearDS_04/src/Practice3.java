// Practice3
// 원형 연결 리스트 (Circular Linked List) 구현

class CircularLinkedList {
    NodeBi head;
    NodeBi tail;

    CircularLinkedList(NodeBi node){
        this.head = node;
        this.tail = node;
        node.next = this.head;
        node.prev = this.head;
    }
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }
    // 연결 리스트에 데이터 추가
    public void addData(int data,Integer beforeData){
            if( this.head == null ){//노드에 아무것도 없었을 때
                NodeBi newNodeBi = new NodeBi(data,null,null);
                this.head = newNodeBi;
                this.tail = newNodeBi;
                newNodeBi.next = newNodeBi;
                newNodeBi.prev = newNodeBi;
            }
            else if(beforeData == null){//before 데이터 없는 경우_제일 끝에 값 추가할 때
                NodeBi newNodeBi = new NodeBi(data, this.head, this.tail);
                this.tail.next = newNodeBi;
                this.head.prev = newNodeBi;
                this.tail = newNodeBi;
            }
            else {//before 데이터 있는 경우 _ 중간에 값을 추가할 때
                NodeBi cur = this.head;
                NodeBi prev = cur;
                do {
                    if(cur.data == beforeData){
                        if(cur == this.head ){//넣어야할 위치가 제일 처음이라면
                            NodeBi newNodeBi = new NodeBi(data,this.head,this.tail);
                            this.head.prev = newNodeBi;
                            this.tail.next = newNodeBi;
                            this.head = newNodeBi;
                            break;
                        }
                        else {//중간이라면
                            NodeBi newNodeBi = new NodeBi(data,cur,prev);
                            prev.next = newNodeBi;
                            cur.prev = newNodeBi;
                        }
                        break;
                    }
                    prev = cur;
                    cur = cur.next;
                } while(cur != this.head); //null이 아니라 this.head로 해쥰 이유가 뭐지 ?
            }
    }
    //  연결 리스트에서 특정 값을 가진 노드 삭제
    public void removeData(int data){
        if(isEmpty()){
            System.out.println("List is Empty");
            return;
        }
        NodeBi cur = this.head;
        NodeBi prev = this.head;

        while(cur != null){
            if(cur.data == data){
                if(cur == this.head && cur == this.tail){ //요소가 단 하나뿐인지
                    this.head = null;
                    this.tail = null;
                }
                else if(cur == this.head){ //지워야하는 요소가 제일 처음
                    //내코드
//                    this.head = cur.next;
//                    cur.next.prev = this.tail; 이것도 맞는 거래 !!!!!!
//                    this.tail.next = this.head;

                    //강사님 코드
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = this.head;
                }
                else if(cur == this.tail){ //지워야하는 요소가 제일 끝
                    prev.next = this.head;
                    this.tail = prev;
                    this.head.prev = this.tail;
                }
                else{//중간값 삭제
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
            System.out.println("List is Empty");
            return;
        }
        NodeBi cur = this.head;
        while(cur.next != this.head){//주의!!!! 얘는 원형리스트라 끝이 처음과 이어져있음 !!! cur != null로하면 무한루프 돔 !
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        CircularLinkedList myList = new CircularLinkedList(new NodeBi(1, null, null));
        myList.addData(2, null);
        myList.addData(3, null);
        myList.addData(4, null);
        myList.addData(5, null);
        myList.showData();  // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData();  // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData();          // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData();          // List is empty!
    }
}
