// Practice3
// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 입출력 예시)
// 입력: "2 2 +"
// 출력: 4

// 입력: "2 2 -"
// 출력: 0

import java.util.Stack;

public class Practice3 {
    public static double calculate(String string) {
        //강사님코드
        Stack <Double>stack = new Stack();
        for(String s : string.split(" ")) {//공백기준으로 문자열을 쪼갬
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(s));
            }
        }
            return stack.pop();
            //내코드
//        Stack <String>stack = new Stack();
//        int data1 = 0;
//        int data2 = 0;
//        double result = 0;
//        for (int i = 0; i < string.length(); i++) {
//            char c = string.charAt(i);
//
//            if('0' <= c && c <= '9'){
//                stack.push(Character.toString(c));
//            }
//            else if(c==' '){
//                continue;
//            }
//            else{
//                int cnt = 0;
//                char op = c;
//                data1 = Integer.parseInt(stack.pop());
//                data2 = Integer.parseInt(stack.pop());
//                switch(op){
//                    case '+':
//                        cnt = data1+data2;
//                        break;
//                    case '*':
//                        cnt =(data1*data2);
//                        break;
//                    case '/':
//                        cnt =(data2/data1);
//                        break;
//                    case '-':
//                        cnt =(data2-data1);
//                        break;
//                }
//                stack.push(Integer.toString(cnt));
//            }
//        }
//        if(!stack.isEmpty()){
//            result = Double.parseDouble(stack.pop());
//        }
//        return result;
    }


    public static void main(String[] args) {
        // Test code
        System.out.println(calculate("2 2 +"));    // 4
        System.out.println(calculate("2 2 -"));    // 0
        System.out.println(calculate("2 2 *"));    // 4
        System.out.println(calculate("2 2 /"));    // 1

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -"));    // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /"));        // 14

    }
}
