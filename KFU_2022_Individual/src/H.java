import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class H {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static char nextChar() {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static long start;
    public static void main(String[] args) {
        start = System.currentTimeMillis();
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        Stupenka[] arr = new Stupenka[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Stupenka();
            arr[i].defau = nextInt();
//            arr[i].map.put(nextInt(), -1);
        }
        arr[0].ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i].ans != -1) {
                arr[i].add(arr[i].defau, arr[i].ans);
            } else {
                continue;
            }
            for (var entry : arr[i].map.entrySet()) {
                if (i + entry.getKey() < n) {
                    arr[i + entry.getKey()].add(entry.getKey(), entry.getValue() + 1);
                }
            }
            if (System.currentTimeMillis() - start >= 1800) {
                pw.println(arr[n - 1].ans);
                return;
            }
            arr[i].map.clear();
        }
        pw.println(arr[n - 1].ans);
    }

    static class Stupenka {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        int defau;

        public void add(int n, int cou) {
            if (map.containsKey(n)) {
                cou = Math.min(cou, map.get(n));
            }
            map.put(n, cou);

            if (ans == -1 || ans > cou) {
                ans = cou;
            }
        }
    }
}
