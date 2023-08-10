import java.util.ArrayList;

public class Practice2 {
    public static void solution(int n) {
        int p1 = 1;
        int p2 = 1;
        ArrayList <Integer>list = new ArrayList<>();
        while (true) {
            int result = p1 * p1 - p2 * p2;
            if (p1 - p2 == 1 && result > n) {
                break;
            }
            if (result < n) {
                p1++;
            } else{
                p2++;
            }
            if (result == n){
                list.add(p1);
            }
        }
        if (list.size() != 0) {
            System.out.println(list);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        // Test code
        solution(15);
    }
}
