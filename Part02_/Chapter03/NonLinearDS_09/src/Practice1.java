// Practice 1
// 자바 기본 PriorityQueue 응용
// 나이 순으로 오름차순 또는 내림차순 출력


import javafx.scene.layout.Priority;

import java.util.Arrays;
import java.util.PriorityQueue;

class Person{
//class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int compareTo(Person o) {
//        // 1 : 변경 안 함.
//        // -1 : 변경
//
//        //this가 원래 있던 거 o가 새로 들어오는 거
//        //새롭게 추가하는 데이터가 더 작을 때 변경 ( 적은 값이 위로 올라감 ,오름차순)
//        //return this.age >= o.age ? 1 : -1;
//        return this.age - o.age;
//        //내림차순
//        //새롭게 추가하는 데이터가 더 클 때 변경 (더 큰 값이 위로 올라감, 내림차순)
//        //return this.age >= o.age ? -1 : 1;
//    }
}

public class Practice1 {
    public static void solution(String[] name, int[] age) {
        PriorityQueue <Person> pq = new PriorityQueue<>();
//        for (int i = 0; i < name.length; i++) {
//            pq.offer(new Person(name[i], age[i]));
//        }
//        while (!pq.isEmpty()) {
//            Person cur = pq.poll();
//            System.out.println(cur.name+" " +cur.age);
//        }
    }

    public static void  main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

        PriorityQueue <Person> pq2 = new PriorityQueue<>(
                (Person p1, Person p2) -> p1.age >= p2.age ? 1 : -1);

        for (int i = 0; i < name.length; i++) {
            pq2.offer(new Person(name[i], age[i]));
        }
        while (!pq2.isEmpty()) {
            Person cur = pq2.poll();
            System.out.println(cur.name+" " +cur.age);
        }
    }
}
