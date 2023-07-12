import java.util.ArrayList;
import java.util.Arrays;

public class Practice1 {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList <ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList <Integer>list1 = new ArrayList<>();
        list1.add(1); //첫 번째 행은 무조건 1
        list.add(list1);

        for (int i = 1; i < numRows; i++) { // 행의 수 만큼 돌아
            list1 = new ArrayList<>();
            for (int j = 0; j < numRows; j++) { //열 만큼 채울
                if( j == 0 ) {
                    list1.add(1); //각 행의 첫 번째 열의 원소는 1
                }
                else if( j == i) {
                    list1.add(1); //그 행의 마지막 원소를 의미
                    break;
                }
                else {
                    list1.add(list.get(i-1).get(j-1) + list.get(i-1).get(j));
                }
            }
            list.add(list1);
        }
        return list;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
    }
}
