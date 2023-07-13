import java.util.LinkedList;
import java.util.Queue;

public class Practice5 {
    static int [][]N = {{1,0},{-1,0},{0,1},{0,-1}};

    static class Point {
        int row,col;
        Point(int r,int c){
            row = r; col = c;
        }
    }
    public static int solution(int[][] grid) {
        int cRow,cCol;
        Queue <Point> q = new LinkedList<>();

        int length = grid.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(grid[i][j] == 1){
                    q.add(new Point(i,j));
                }
            }
        }
        int total = 0;

        while(!q.isEmpty()){
            int tmpCnt = 0;
            Point curr = q.remove(); //현재 좌표

            for (int i = 0; i < 4; i++) { //현재좌표의 상하좌우를 검사
                cRow = curr.row + N[i][0]; cCol = curr.col + N[i][1];

                if(cRow < 0 || cRow > grid.length-1 || cCol < 0 || cCol > grid.length-1)
                    continue;
                if(grid[cRow][cCol] == 1){
                    tmpCnt++; // 맞닿아있는 면이 1인 갯수
                }
                if(grid[cRow][cCol] == 0) continue;
            }
            total += (4-tmpCnt);
        }
        return total;
    }
    
    // 재귀 풀이
    public static int solution2(int[][] grid) {

        return 0;
    }

    public static int recursion(int[][] grid, int[][] directions, int i, int j) {

        return 0;
    }

    public static void main(String[] args) {
        // Test code
        int[][] grid = {{1}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
        System.out.println();

        grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
    }
}
