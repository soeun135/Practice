import java.util.HashMap;

public class Practice1 {
    public static void solution(String s) {
        //char []str = {'I','V','X','L','C','D','M'};
        int result = 0;
        String str = "IVXLCDM";
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);map.put('V',5);map.put('X',10);map.put('L',50);map.put('C',100);map.put('D',500);map.put('M',1000);

        int sum = 0;
        boolean twin = false;
        int i = 1;
        while(true){
            if(i >= s.length()) break;

            char c = s.charAt(i);
            char c_ = s.charAt(i-1);
            if(str.indexOf(c_) < str.indexOf(c)){
                sum += map.get(c)-map.get(c_);
                i+=2;
                twin = true;
            }
            else{
                sum += map.get(c_);
                twin = false;
                i++;
            }
        }
        if(!twin){
            sum += map.get(s.charAt(s.length()-1));
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        // Test code
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");
        solution("CXXXXV");

    }
}
