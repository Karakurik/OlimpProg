import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class tin1 {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
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
            throw new IllegalArgumentException();
        }
    }

    static char nextChar() {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws IOException {
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
        int maxL = 1;
        int maxLId = 1;
        int n = nextInt();
        int[] val = new int[n+1];
        for (int i = 1; i <= n; i++) {
            val[i] = nextInt();
        }

        int[][] dp = new int[n + 1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            int id = i - 1;
            while (val[id] >= val[i]) {
                id--;
                if (id == 0) break;
            }
            if (id == 0) {
                dp[i][0] = 1;
                dp[i][1] = 1;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (dp[id][0] < dp[j][0] && val[i] > val[j]) {
                    id = j;
                }
            }

            int cou = 0;
            for (int j = 1; j <= i-1; j++) {
                if (dp[id][0] == dp[j][0]) {
                    cou += dp[j][1];
                }
            }
            dp[i][0] = dp[id][0]+1;
            dp[i][1] = cou;
            if (dp[i][0]>maxL) {
                maxL=dp[i][0];
                maxLId = id;
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (maxL == dp[i][0]) {
                ans += dp[i][1];
            }
        }
        pw.println(ans);
    }
}
