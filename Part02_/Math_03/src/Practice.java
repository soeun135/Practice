// Practice
// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수

import java.util.ArrayList;
import java.util.HashSet;

public class Practice {
    
//  약수
    public ArrayList getDivisor(int num) {
        ArrayList result = new ArrayList();
        for (int i = 1; i <= (int)num/2; i++) {
            if(num % i == 0){
                result.add(i);
            }
        }
        result.add(num);
        return result;
    }

//  최대 공약수
//  GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;
//        numA = Math.max(numA,numB);
//        numB = Math.min(numA,numB);
//
//        if(numA % numB ==0){
//            gcd = numB;
//        }
//        else {
//            gcd = getGCD(numB, numA%numB);
//        }
        //강사님 방식
        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        for(int itemA : (ArrayList<Integer>)divisorA){
            for(int itemB : (ArrayList<Integer>)divisorB){
                if(itemA == itemB){
                    if(itemA > gcd)
                        gcd = itemA;
                }
            }
        }

        return gcd;
    }

//  최소 공배수
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;
        lcm = numA*numB/getGCD(numA,numB);

        //강사님 코드
//        int gcd = th9os.getGCD(numA,numB);
//        if(gcd != 1_{
//          lcm = numA * numB /gcd;
        return lcm;
    }

    public static void main(String[] args) {

//      Test code
        int number1 = 10;
        int number2 = 6;

        Practice p = new Practice();
        ArrayList l1 = p.getDivisor(number1);   // 10: 1, 2, 5, 10
        ArrayList l2 = p.getDivisor(number2);   // 6: 1, 2, 3, 6
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수: " + p.getGCD(number1, number2));
        System.out.println("최대 공배수: " + p.getLCM(number1, number2));

        //활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
//        HashSet<ArrayList> set1 = new HashSet<>(l1);
//        set1.addAll(l2);
//        System.out.println(set1);

        // 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수
        HashSet<ArrayList> set1 = new HashSet<>(l1);
        HashSet<ArrayList> set2 = new HashSet<>(l2);
        set1.retainAll(set2);
        System.out.println(set1);
    }
}
