import java.util.Arrays;

public class Practice4 {
    final static int numOfTree = 2;

    public static int solution(int[] order, int k) {
        if (order == null || order.length == 0) {
            return -1;
        }
        //dp방식
        int n = order.length;
        int dp[][][] = new int[k + 2][numOfTree + 1][n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 2; j++) {
                if (order[i] == 1) {
                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]) + 1;
                    dp[j][2][i] = Math.max(dp[j][2][i - 1], dp[j - 1][1][i - 1]);
                } else {
                    if (i == 1 && j == 1) {
                        continue;
                    }

                    dp[j][1][i] = Math.max(dp[j][1][i - 1], dp[j - 1][2][i - 1]);
                    dp[j][2][i] = Math.max(dp[j][2][i - 1], dp[j - 1][1][i - 1]) + 1;
                }
            }
        }
        int result = 0;
        for (int i = 1; i < k + 2; i++) {
            result = Math.max(result, Math.max(dp[i][1][n - 1], dp[i][2][n - 1]));
        }
        return result;

        //내가 푼 거/
//        int dp[] = new int[order.length];
//
//        for (int i = 0; i < order.length; i++) {
//            int cur = 1;
//            int move = 0;
//            int idx = i;
//            while (idx < order.length && move < k) {
//                if (cur != order[idx]) {
//                    move++;
//                    cur = order[idx];
//                }
//                if (cur == order[idx]) {
//                    dp[i]++;
//                }idx++;
//            }
//            while (idx < order.length && cur == order[idx]) {
//                dp[i]++;
//                idx++;
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        // Test code
        int[] order = {2, 1, 1, 2, 2, 1, 1};
        int k = 2;
        System.out.println(solution(order, k));
    }
}
