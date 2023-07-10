import java.util.HashMap;
import java.util.LinkedList;

public class Practice2 {
    public static String solution(int num){
        String result = "";
        //HashMap<Character,Integer> map = new HashMap<>();
        //map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);map.put('C',100);map.put('D',500);map.put('M',1000);
        char charArr[] = {'M','D','C','L','X','V','I'};
        int intArr[] = {1000,500,100,50,10,5,1};

        int tenMulti = 1;

        while(num > 1){
            int rest = num % 10;
            num /= 10;
            String tempStr = "";
            boolean twin = false;
            for (int i = 0; i < intArr.length; i++) {
                //혼합문자열일 경우
                if(i % 2 == 0 && i != 6){
                    if(rest * tenMulti == intArr[i+1]-intArr[i]){
                        tempStr += charArr[i];
                        tempStr += charArr[i+1];
                        result = tempStr;
                        break;
                    }
                    else if(rest * tenMulti == intArr[i+2]-intArr[i]){
                        tempStr += charArr[i];
                        tempStr += charArr[i+2];
                        result = tempStr;
                        break;
                    }
                }
                //혼합문자열이 아님
                else{
                    for (int j = intArr.length-1; j >= 0; j--) {
                        if(rest % intArr[j] == 0){
                            for (int k = 0; k < rest/intArr[j]; k++) {
                                tempStr += charArr[j];
                                result = tempStr;

                            }
                        }
                    }
                }
            }
            tenMulti *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
//        System.out.println(solution(4));
//        System.out.println(solution(6));
//        System.out.println(solution(13));
//        System.out.println(solution(26));
//        System.out.println(solution(1994));
    }
}
