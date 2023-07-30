// Practice 2
// 문자열 사전식 오름차순

import java.util.Comparator;
import java.util.PriorityQueue;

//class Person2{
class Person2 implements Comparator<Person2> {
    String name;
    int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(Person2 o1, Person2 o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class Practice2 {
    public static void solution(String[] name, int[] age) {
//        PriorityQueue <Person2> pq = new PriorityQueue<>((Person2 p1, Person2 p2) -> p2.name.compareTo(p1.name));
        PriorityQueue <Person2> pq = new PriorityQueue<>();
        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person2(name[i], age[i]));
        }
        while (!pq.isEmpty()) {
            Person2 cur = pq.poll();
            System.out.println(cur.name+" " +cur.age);
        }
    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

    }
}
