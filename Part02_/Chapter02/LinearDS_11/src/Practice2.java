// Practice1
// Palindrome 찾기
// Palindrome 이면 true, 아니면 false 를 반환하세요.
// Palindrome: 앞으로 읽어도 거꾸로 읽어도 같은 문자열

// 입출력 예시)
// 입력: a
// 결과: true

// 입력: madam
// 결과: true

// 입력: abab
// 결과: false


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Practice2 {
    public static boolean checkPalindrome(String str) {
        Deque deque = new ArrayDeque();
        //강사님 코드
        boolean isFront = true;
        boolean isPalindrome = true;

        for(String s : str.split("")){
            deque.add(s);
        }
//        while(!deque.isEmpty()){
//            String s1 = (String)deque.pollFirst(); //remove 써서 여기서 꺼냈을때 deque에 아무 것도 없으면 아랫 줄에서 에러가 발생해서 프로그램 종료됨.
//            String s2 = (String)deque.pollLast();
//
//            if(s1 != null && s2 != null && !s1.equals(s2)){
//                isPalindrome = false;
//                break;
//            }
//        }

        //내코드
        if(deque.size() == 1) return true;
        while(deque.size() > 1){
            if(deque.pollFirst().equals(deque.pollLast())){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(checkPalindrome("a"));       // true
        System.out.println(checkPalindrome("aba"));     // true
        System.out.println(checkPalindrome("abba"));    // true
        System.out.println(checkPalindrome("abab"));    // false
        System.out.println(checkPalindrome("abcba"));   // true
        System.out.println(checkPalindrome("abccba"));  // true
        System.out.println(checkPalindrome("madam"));  // true
    }
}
