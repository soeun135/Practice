// 알고리즘 - 백트래킹

public class Main {

    static int n = 4;
    static int[] board = new int[n];
    static int cnt;
    public static int nQueen(int row) {
        if (row == n) {
            cnt++;

            for (int i = 0; i < n; i++) {
                System.out.println(board[i] + " ");
            }
            System.out.println();
            return cnt;
        }
        for (int i = 0; i < n; i++) {
            board[row] = i;

            // promising
            if (isPromising(row)) {
                nQueen(row + 1);
            }
        }
        return cnt;
    }

    public static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                //같은 열 of 대각선상에 있는지 검사하는 케이스
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // Test code
        System.out.println("경우의 수: " + nQueen(0));  // 2
    }
}
