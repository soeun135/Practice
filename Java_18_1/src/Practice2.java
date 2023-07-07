import java.util.Scanner;

public class Practice2 {
    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("문자 입력 : ");
        char c = scanner.next().charAt(0);
        //내코드
//        if('a'<=c && c<='z'){
//            System.out.println((char)(c-32));
//        }
//        else{
//            System.out.println((char)(c+32));
//        }
        //강사님 코드
        int output = 0;
        int step = (int)'a' - (int)'A';

        if(c >= 'a' && c <= 'z'){
            output = (int)c - step;
            System.out.println("대문자 출력 : "+(char)output);
        }
        else if( c>='A' && c<='Z'){
            output = (int)c + step;
            System.out.println("소문자 출력 : "+(char)output);
        }
        else{
            System.out.println("입력하신 값이 알파벳이 아닙니다.");
        }
    }

    public static void reference() {
        int a = (int)'a';
        System.out.println("a = " + a);
        int z = (int)'z';
        System.out.println("z = " + z);
        int A = (int)'A';
        System.out.println("A = " + A);
        int Z = (int)'Z';
        System.out.println("Z = " + Z);
        int etc = (int)'%';
        System.out.println("etc = " + etc);
    }

    public static void main(String[] args) {
        reference();    // 아스키 코드 참고
        solution();
    }
}
