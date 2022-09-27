import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {
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
        int t = 1;
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int q = nextInt();
        int[] dp = new int[n + 1];
        long[] high = new long[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int h = nextInt();
            high[i] = high[i - 1] + h;
            dp[i] = Math.max(dp[i-1], h);
        }
        for (int i = 0; i < q; i++) {
            int t = nextInt();
            if (t >= dp[n]) {
                pw.printf("%d ", high[n]);
            } else {
                int res = Arrays.binarySearch(dp, t);
                if (res < 0) res = -res-2;
                for (int j = res+1; j < n; j++) {
                    if (dp[res] == dp[j]) res = j;
                    else {
                        break;
                    }
                }
                pw.printf("%d ", high[res]);
            }
        }
        pw.println();
    }
}
