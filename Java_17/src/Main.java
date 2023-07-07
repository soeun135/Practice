// Java 프로그래밍 - 스트림

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//      1. 스트림 생성

//      1-1. 배열 스트림
        System.out.println("== 배열 스트림 == ");
        String[] arr = new String[]{"a", "b", "c"};

        System.out.println("== fori ==");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("== forEach ==");
        for (String item: arr) {
            System.out.println(item);
        }

        System.out.println("== to Stream ==");
        Stream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);

//      1-2. 컬렉션 스트림
        System.out.println("== 컬렉션 스트림 ==");
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println("list1 = " + list1);

        System.out.println("== to Stream ==");
        Stream stream1 = list1.stream();
       //stream1.forEach(System.out::println);
        stream1.forEach(num -> System.out.println("num = "+num));

//      1-3. 스트림 builder
        System.out.println("== 스트림 builder ==");
        Stream stream2 = Stream.builder().add(2).add(3).add(5).build();
        stream2.forEach(System.out::println);


//      1-4. 스트림 generate
        System.out.println("== 스트림 generate ==");
        Stream streamGenerate = Stream.generate( () -> 4456).limit(3);
        streamGenerate.forEach(System.out::println);

//      1-5. 스트림 iterate
        System.out.println("== 스트림 iterate ==");
        Stream streamIterate = Stream.iterate(10, n->n+2).limit(5);
        streamIterate.forEach(System.out::println);


//      1-6. 기본 타입 스트림
        System.out.println("== 기본타입 스트림 ==");
        IntStream intStream = IntStream.range(1,5);
        intStream.forEach(System.out::println);

//      2. 스트림 중개 연산

//      2-1. Filtering
        System.out.println("== Filtering ==");
        IntStream stream3 = IntStream.builder().add(10).build();
        stream3 = IntStream.iterate(20, n -> n + 1).limit(5);
      //  stream3.forEach(System.out::println);
        stream3 = stream3.filter(n -> n % 2 == 0);
        stream3.forEach(System.out::println);
//        IntStream intStream3 = IntStream.range(1,11).filter(n->n%2!=0);
//        intStream3.forEach(System.out::println);

//      2-2. Mapping
        System.out.println("== Mapping ==");
        IntStream intStream4 = IntStream.range(1,10).map(n->n*2);
        intStream4.forEach(x -> System.out.print(x + " "));
        System.out.println();

//      2-3. Sorting
        System.out.println("== Sorting ==");
        IntStream intStream5 = IntStream.builder().add(5).add(1).add(3).add(4).add(2).build();
        IntStream intStreamSort = intStream5.sorted();
        intStreamSort.forEach(System.out::println);

//      3. 최종 연산

//      3-1. Sum, Average
        System.out.println("== sum, average ==");
        int sum = IntStream.range(1,5).sum();
        System.out.println(sum);
        double avg = IntStream.range(1,10).average().getAsDouble();
        System.out.println(avg);

//      3-2. Min, Max
        System.out.println("== min, max ==");
        int min = IntStream.range(1,10).min().getAsInt();
        System.out.println(min);
        System.out.println(IntStream.range(1,100).max().getAsInt());

//      3-3. reduce
        System.out.println("== reduce ==");
        Stream<Integer> stream6 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)).stream();
        System.out.println(stream6.reduce((x,y) -> x+y).get());


//      3-4. forEach
        System.out.println("== forEach == ");
        IntStream.range(1,10).filter(n -> n != 1).forEach(System.out::println);


    }
}


