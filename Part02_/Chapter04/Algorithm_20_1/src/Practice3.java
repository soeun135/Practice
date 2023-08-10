import java.util.ArrayList;
import java.util.HashMap;

public class Practice3 {

    public static int solution(int n, int[] items) {
        if (items == null || items.length == 0) {
            return -1;
        }
        boolean[] used = new boolean[items.length + 1];

        int idx = 0;
        int cnt = 0;
        while (cnt < n) {
            if (!used[items[idx]]) {
                used[items[idx]] = true;
                cnt++;
            }
            idx++;
        }
        int result = 0;
        while (idx < items.length) {
            if (!used[items[idx]]) {
                ArrayList <Integer> list = new ArrayList<>();
                for (int i = idx; i < items.length; i++) {
                    if (used[items[i]] && !list.contains(items[i])) {
                        list.add(items[i]);
                    }
                }

                if (list.size() == n) { //나중에도 사용하게 될 애들이 현재 다 꽂혀있는 경우
                    used[list.get(n - 1)] = false;
                } else {
                    for (int i = 1; i <= items.length ; i++) {
                        if (used[i] && !list.contains(i)) {
                            used[i] = false;
                            break;
                        }
                    }
                }
                used[items[idx]] = true;
                result++;
            }
            idx++;
        }
        return result;

        //내코드
//        int answer = 0;
//        HashMap <Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < items.length ; i++) {
//            map.put(items[i], map.getOrDefault(items[i], 0) + 1);
//        }
//        ArrayList <Integer>list = new ArrayList<>();
//        for (int i = 0; i < items.length ; i++) {
//            if (!list.contains(items[i])) {
//                list.add(items[i]);
//            }
//            if (list.size() > n) {
//                int min = map.get(list.get(0)) > map.get(list.get(1)) ? list.get(1) : list.get(0);
//                list.remove(Integer.valueOf(min));
//                answer++;
//            }
//        }
//        return answer;
    }

    public static void main(String[] args) {
        // Test code
        int n = 2;
        int[] items = {2, 3, 2, 3, 1, 2, 7};
        System.out.println(solution(n, items));
    }
}
