import java.util.ArrayList;

public class Practice1 {
    public static ArrayList<ArrayList<Integer>> solution(int numRows) {
        ArrayList <ArrayList<Integer>> list = new ArrayList();

        for (int i = 0; i < numRows; i++) { //행 수만큼 출력
            ArrayList <Integer> innerList = new ArrayList();  //각 행에 대한 파스칼 삼각형 수를 담음.
            for (int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i){
                    innerList.add(1);
                } else{
                    innerList.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
                }
            }
            list.add(innerList);
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
