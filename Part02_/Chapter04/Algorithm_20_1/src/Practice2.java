import java.util.Arrays;
import java.util.HashSet;

public class Practice2 {
    public static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }
        //강사님 코드
        int []selected = new int[types + 1]; //1번부터 사용할 배열
        
        int cnt = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (selected[plates[i]] == 0) {
                cnt++;
            }
            selected[plates[i]]++;
        }
        max = cnt;

        for (int i = 1; i < plates.length; i++) {

            if (max <= cnt) {
                if (selected[coupon] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }
            int p1 = i - 1;
            int p2 = (i + n - 1) % plates.length;

            selected[plates[p1]]--;
            if (selected[plates[p1]] == 0) {
                cnt--;
            }
            if (selected[plates[p2]] == 0) {
                cnt++;
            }
            selected[plates[p2]]++;
        }
        return max;
        //투포인터 방식
//        int p1 = 0;
//        int p2 = p1 + 4;
//        int max = Integer.MIN_VALUE;
//        while (p1 < plates.length) {
//            HashSet <Integer> set = new HashSet<>();
//            for (int i = p1; i < p2 ; i++) {
//                set.add(plates[i % plates.length]);
//            }
//            set.add(coupon);
//            System.out.println(set.size());
//            if (max < set.size()) {
//                max = set.size();
//            }
//            p1++;
//            p2 = p1 + 4;
//        }
//        return max;
        //dp 내가 푼 거
//        int dp[] = new int[plates.length];
//        for (int i = 0; i < plates.length; i++) {
//            HashSet <Integer> set = new HashSet<>();
//            for (int j = i; j < i + 4; j++) {
//                set.add(plates[j % plates.length]);
//            }
//            set.add(coupon);
//            dp[i] = set.size();
//        }
//        System.out.println(Arrays.toString(dp));
//        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        // Test code
        int n = 4;
        int[] plates = {7, 9, 7, 30, 2, 7, 9, 25};
        int types = 30; //총 초밥의 종류
        int coupon = 30;
        System.out.println(solution(n, plates, types, coupon));
    }
}
