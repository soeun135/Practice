// 선형 자료구조 - 큐


import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue q = new LinkedList();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);

        System.out.println(q.poll());
        System.out.println(q);

        System.out.println(q.poll());
        System.out.println(q);

        System.out.println(q.peek());
        System.out.println(q);

        System.out.println(q.contains(3));
        System.out.println(q.size());
        System.out.println(q.isEmpty());

        q.clear();
        System.out.println(q);
        System.out.println(q.poll());
    }
}
