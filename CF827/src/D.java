import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D {
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

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        for (int i = 0; i < 1001; i++) {
            for (int j = i; j < 1001; j++) {
                ans[i][j] = gcd(i, j);
                ans[j][i] = ans[i][j];
            }
        }
        int t = 1;
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static int[][] ans = new int[1001][1001];

    private static void solve() {
        int n = nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nextInt(), i + 1);
        }
        int max = -1;
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                if (map.containsKey(i) && map.containsKey(j) && gcd(i, j) == 1) {
                    max = Math.max(max, map.get(i) + map.get(j));
                }
            }
        }
        pw.println(max);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : ans[b][a % b] != 0 ? ans[b][a % b] : gcd(b, a % b);
    }
}
