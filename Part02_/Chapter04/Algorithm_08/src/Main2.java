// 거스름돈 문제

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void getChangeCoins(int receivedMoney, int price) {
        final int arr[] = {500, 100, 50, 10, 5, 1};
        HashMap <Integer, Integer> map = new HashMap<>();
        int change = receivedMoney - price;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (change < arr[i]) {
                continue;
            }
            int q = change / arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + q);
            result += q;
            change %= arr[i];
        }
        System.out.println("총 잔돈 갯수" + result);
        for (Map.Entry <Integer, Integer>item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue() + " ");
        }
    }

    public static void main(String[] args) {
        // Test code
        getChangeCoins(1000, 100);
        getChangeCoins(1234, 500);
    }
}
