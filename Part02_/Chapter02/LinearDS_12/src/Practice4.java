// Practice4
// 해시 충돌 해결 - 개방 주소법 (이중 해싱)

class MyHashTable4 extends MyHashTable {
    int c;
    MyHashTable4(int size) {
        super(size);
        this.c = this.getHashC(size);
    }
    public int getHashC(int size){ //테이블의 크기보다 조금 작은 소수를 구하는 메소드
        int c = 0;
        if(size <= 2){
            return size;
        }
        for (int i = size - 1; i > 2; i--) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                c = i;
                break;
            }
        }
        return c;
    }
    public int getHash2(int key){ //두번째 해시함수를 구하기 위한 메소드
        int hash = (1 + key) % this.c; //새롭게 얻는 해시. c는 테이블 보다 조금 작은 소수.
        return hash;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);
        if(this.elemCnt == this.table.length){ //충돌관계없이 꽉 참
            System.out.println("HashTable is Full !");
            return;
        }
        else if(this.table[idx] == null){
            this.table[idx] = data;
        }
        else{
            int newIdx = idx;
            int cnt = 1;
            while (true){
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;
    }

}
public class Practice4 {
    public static void main(String[] args) {
        // Test code
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();


        ht.setValue(1, 100);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();
    }
}
