// 비선형 자료구조 - 트라이 (Trie)

import java.util.HashMap;

class Node {
    HashMap<Character,Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;
    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) { //문자열이 들어오면 단어 하나하나 끊어서 trie에 저장
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node()); //해당 문자로 시작하는 노드가 없으면 노드 생성
            cur = cur.child.get(c);

             if (i == str.length() - 1) {
                 cur.isTerminal = true; //문자열의 끝까지 도달했으면 isTerminal을 true로 바꿔줌.
                 return;
             }
        }
    }

    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }

            if (i == str.length() - 1) { //인덱스가 찾고자하는 문자열의 끝이면
                //바로 true를 뱉어주면 안 됨 ! 문자열과 같은지 비교해줘야함.
                if (!cur.isTerminal) { //유의
                    return false;
                }
            }
        }
        return true;
    }
    public void delete(String str) {
        boolean ret = this.delete(this.root, str, 0);
        if (ret) {
            System.out.println(str + " 삭제완료");
        } else {
            System.out.println(str + " 단어가 없습니다.");
        }
    }
    public boolean delete (Node node, String str, int idx) {
        char c = str.charAt(idx);

        if (!node.child.containsKey(c)) { //현재 노드 child 쪽에 key 가 없으면
            return false;
        }
        Node cur = node.child.get(c);
        idx++;

        if (idx == str.length()) { //문자열 끝에 도달했을 때 삭제 여부 결정
            if (!cur.isTerminal) { //단말이 아니었으면 삭제하면 안 됨.
                return false;
            }

            cur.isTerminal = false; //단말이었으면 먼저 false로 바꾸고

            if (cur.child.isEmpty()) {//해당 문자로 파생되는 단어가 없다는 말
                node.child.remove(c);
            }
        } else { //지워야하는 단어를 찾기 전
            if (!this.delete(cur, str, idx)) {
                return false;
            }

            if (!cur.isTerminal && cur.child.isEmpty()) {
                node.child.remove(c);
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test code
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
//        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("app"));      // true
        System.out.println(trie.search("ace"));     // true
        System.out.println(trie.search("bear"));    // true
        System.out.println(trie.search("best"));    // true
        System.out.println(trie.search("abc"));     // false

        System.out.println();
        trie.delete("apple");
        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("april"));   // true
        System.out.println(trie.search("appl"));    // false
        trie.delete("apple");
    }
}
