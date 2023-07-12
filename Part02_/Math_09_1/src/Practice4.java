import java.util.ArrayList;
import java.util.HashSet;

public class Practice4 {
    public static boolean solution(int n) {
        int result = 0;
        int rest = 0;
        boolean flag = false;

        if(n == 1){ //n이 1이 나오면 탈출
            return true;
        }
        while(n != 0){
            rest = n % 10;
            result += (int)Math.pow(rest,2);
            n /= 10;
        }
        flag = solution(result);

        return flag;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}
