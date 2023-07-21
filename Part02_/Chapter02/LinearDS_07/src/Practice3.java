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
        Stack <Integer> stack = new Stack();
        double result = 0;
        for(String s : string.split(" ")){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(s.equals("+")){
                    stack.push(num1 + num2);
                } else if(s.equals("-")){
                    stack.push(num2 - num1);
                } else if(s.equals("*")){
                    stack.push(num2 * num1);
                } else {
                    stack.push(num2 / num1);
                }
            } else{
                stack.push(Integer.parseInt(s));
            }
        } result = stack.pop();
        return result;
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
