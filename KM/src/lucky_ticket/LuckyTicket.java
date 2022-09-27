package lucky_ticket;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class LuckyTicket {
    public static Map<Integer, BigInteger> startMap = new HashMap<>();

    public static void main(String[] args) {
        int n = 100;
        for (int i = 0; i <= 9; i++) {
            startMap.put(i, BigInteger.valueOf(9 - i + 1));
            startMap.put(-i, BigInteger.valueOf(9 - i + 1));
        }
        Map<Integer, BigInteger> ans = mapTicket(n / 2);
        System.out.println(ans.get(0));
    }

    private static Map<Integer, BigInteger> mapTicket(int n) {
        Map<Integer, BigInteger> ans = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            ans.put(i, BigInteger.valueOf(9 - i + 1));
            ans.put(-i, BigInteger.valueOf(9 - i + 1));
        }
        for (int i = 1; i < n; i++) {
            ans = mapMultiply(ans);
        }
        return ans;
    }

    private static Map<Integer, BigInteger> mapMultiply(Map<Integer, BigInteger> map) {
        Map<Integer, BigInteger> ans = new HashMap<>();
        for (var e1 : map.entrySet()) {
            for (var e2 : startMap.entrySet()) {
                if (ans.containsKey(e1.getKey() + e2.getKey())) {
                    ans.put(
                            e1.getKey() + e2.getKey(),
                            ans.get(e1.getKey() + e2.getKey()).add(e1.getValue().multiply(e2.getValue()))
                    );
                } else {
                    ans.put(
                            e1.getKey() + e2.getKey(),
                            e1.getValue().multiply(e2.getValue())
                    );
                }
            }
        }
        return ans;
    }
}

