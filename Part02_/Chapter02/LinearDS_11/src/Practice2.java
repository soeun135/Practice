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


import java.util.Deque;
import java.util.LinkedList;

public class Practice2 {
    public static boolean checkPalindrome(String str) {
        Deque deque = new LinkedList();
        for(String s : str.split("")){
            deque.add(s);
        }
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
