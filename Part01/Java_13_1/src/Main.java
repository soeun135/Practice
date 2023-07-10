// Java 프로그래밍 - 입출력_1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void referInputStream() throws IOException {
//      System.in
        System.out.println("== System.in ==");
//        System.out.print("입력 : ");
//        int a = System.in.read() - '0';
//        System.out.println("a = " + a);
//        System.in.read(new byte[System.in.available()]); //입력스트림에 남아있는 갯수만큼 바이트형태로 읽어서 데이터를 소진해줌.
        
//      InputStreamReader
        System.out.println("== InputStreamReader ==");
//        InputStreamReader ir = new InputStreamReader(System.in);
//        char[] c = new char[3];
//        System.out.print("입력:");
//        ir.read(c);
//        System.out.println(c);

//      BufferedReader
        System.out.println("== BufferedReader ==");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.print("입력 : ");
//        String s1 = br.readLine();
//        System.out.println("s1 = " + s1);
    }

    public static void main(String[] args) throws IOException {

//      1. 입력
//      1-1. 다른 입력 방식 참고
//        referInputStream();

//      1-2. Scanner
        System.out.println("== Scanner ==");
        Scanner scanner = new Scanner(System.in);
//        System.out.print("입력 :");
//        System.out.println(scanner.next());
//        scanner.nextLine();

//        System.out.print("입력 2 :");
//        System.out.println(scanner.nextInt());
//        scanner.nextLine();

//        System.out.print("입력 3 :");
//        System.out.println(scanner.nextLine());

//      참고) 정수, 문자열 변환
        int num = Integer.parseInt("123");
        String str = Integer.toString(123);
        
//      2. 출력
        System.out.println("== 출력 ==");
        String s = "자바";
        int number = 3;

        System.out.println(s+"는"+number+"입니다.");
        System.out.printf("%s는 %d입니다. \n",s,number);

        System.out.printf("%5d \n",123);
        System.out.printf("%5d \n",1234);
        System.out.printf("%5d \n",12354);

        System.out.printf("%.2f \n",1.345523);
    }
}
