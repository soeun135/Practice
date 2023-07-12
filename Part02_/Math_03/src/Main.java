// 기초 수학 - 경우의 수

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

//      1. 합의 법칙
        System.out.println("== 합의 법칙 ==");
//      두 개의 주사를 던졌을 때 합이 3 또는 4의 배수일 경우의 수

        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

        int nA = 0;
        int nB = 0;
        int nAandB = 0;
        
        // 기본 풀이
        for(int a : dice1){
            for(int b:dice2){
                if((a+b) % 3 == 0) nA ++;
                if((a+b) % 4 ==0) nB++;
                if((a+b) % 12 == 0) nAandB++;
            }
        }
        System.out.println(nA+nB-nAandB);

        // HashSet 이용
        HashSet <ArrayList> set = new HashSet<>();

        for(int a : dice1){
            for(int b:dice2){
                if((a+b) % 3 == 0 || (a+b) % 4 == 0){
                    ArrayList list = new ArrayList(Arrays.asList(a,b));
                    set.add(list);
                }
            }
        }
        System.out.println(set+" \n경우의 수 : "+set.size());

//      2. 곱의 법칙
        System.out.println("== 곱의 법칙 ==");
//      두 개의 주사위 a, b를 던졌을 때 a는 3의 배수, b는 4의 배수인 경우의 수
        nA = 0;
        nB = 0;
        for(int a : dice1){
            if(a % 3 == 0) nA++;
        }
        for(int b : dice2){
            if(b % 4 == 0) nB++;
        }
        System.out.println("곱 :"+nA*nB);
    }
}
