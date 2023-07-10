// 기초 수학 - 조합

public class Main {
    static int getCombination(int n,int r){//nCr
        int result = 1;
        for (int i = n; i >= n - r + 1; i--) {
            result *= i; //nPr
        }
        for (int i = 1; i <= r; i++) {
            result /= i;//r!
        }
        return result;
    }

    public static void main(String[] args) {
//      1. 조합
        System.out.println("== 조합 ==");

        int n = 4;
        int r = 2;
        int result = 1;

        for (int i = n; i >= n - r + 1; i--) {
            result *= i; //nPr
        }
        for (int i = 1; i <= r; i++) {
            result /= i;//r!
        }
        System.out.println(result);

//      2. 중복 조합
        System.out.println("== 중복 조합 ==");
        n = 2;
        r = 3;
        result = 1;
        //n+r-1Cr
        System.out.println(       getCombination(n+r-1,r));

    }
}
