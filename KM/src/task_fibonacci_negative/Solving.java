package task_fibonacci_negative;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solving {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        solve();
        pw.close();
    }

    public static void solve() {
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        for (int i = 2; i <= n; i++) {
            map.put(i, map.get(i - 2) + map.get(i - 1));
        }
        for (int i = 1; i <= n; i++) {
            map.put(-i, map.get(i) * (int) Math.pow(-1, (i - 1) % 2));
        }

        for (int i = 0; i <= n; i++) {
            pw.printf("Fibonacci(%d) = %d\t", i, map.get(i));
            pw.printf("Fibonacci(%d) = %d\n", -i, map.get(-i));
        }
    }
}
