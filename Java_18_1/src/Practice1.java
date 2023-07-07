
public class Practice1 {
    public static void solution(int num) {
        //내코드
//        int answer = 0;
//        while(num != 0){
//            answer = (num % 10)+(answer * 10);
//            num /= 10;
//        }
//        System.out.println(answer);

        //강사님 코드
        int numReverse = 0;
        boolean minus = false;

        if(num < 0) {
            minus = true;
            num*= -1;
        }
        while(num > 0){
            int r = num % 10;
            num /= 10;
            numReverse = numReverse*10 +r;
        }
        System.out.println(minus ? numReverse*-1 : numReverse);
    }

    public static void main(String[] args) {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}
