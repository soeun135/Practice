import java.util.ArrayList;
import java.util.HashSet;

public class Practice4 {
    public static boolean solution(int n) {
        HashSet<Integer> set = new HashSet<>();

        while(set.add(n)){
            int sqaureSum = 0;
            while( n > 0){
                int remain = n % 10;
                sqaureSum += remain * remain;
                n /= 10;
            }
            if(sqaureSum == 1){
                return true;
            } else{
                n = sqaureSum;
            }
        }
        return false;
//        int result = 0;
//        boolean flag = false;
//        int checkRest = (int)Math.pow(n % 10, 2);
//        while(n != 0){
//            result = 0;
//            int rest = n % 10;
//            result += (int)Math.pow(rest, 2);
//            n /= 10;
//            if(checkRest == result){
//                flag = false;
//                break;
//            }
//        }
//        if(n == 1){
//            flag = true;
//        }
//        return flag;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
}
