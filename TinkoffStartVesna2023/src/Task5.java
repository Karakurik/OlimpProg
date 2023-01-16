import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Task5 {
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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        long time = System.currentTimeMillis();

        int n = nextInt();
        int m = nextInt();
        List<Integer>[][] lists = new List[n][2];
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                lists[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            int t = nextInt();
            lists[v][t].add(u);
        }

        BigInteger iters = BigInteger.TWO;
        iters = iters.pow(n);

        int[] help = new int[n];

        int ans = -1;
        StringBuilder sb = new StringBuilder();

        for (BigInteger i = BigInteger.ONE; i.compareTo(iters) < 0; i = i.add(BigInteger.ONE)) {
            if (System.currentTimeMillis() - time > 1950) break;

            forMinus1(dp);
            if (help[0] == 0) {
                dp[0][0] = 0;
            } else {
                dp[0][1] = 0;
            }

            for (int j = 1; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    for (Integer u : lists[j][k]) {
                        if (dp[u][k] != -1) {
                            if (dp[j][help[j]] == -1 || dp[j][help[j]] > dp[u][k] + 1) {
                                dp[j][help[j]] = dp[u][k] + 1;
                            }
                        }
                    }
                }
            }

            int localAns = dp[n - 1][0];
            if (localAns == -1 || localAns > dp[n - 1][1] && dp[n - 1][1] != -1) {
                localAns = dp[n - 1][1];
            }
            if (localAns == -1) {
                pw.println(-1);
                for (int el : help) {
                    pw.print(el);
                }
                pw.println();
                return;
            }

            if (ans == -1 || localAns > ans) {
                ans = localAns;
                sb = new StringBuilder();
                for (int el : help) {
                    sb.append(el);
                }
            }
            plus1(help);
        }

        pw.println(ans);
        pw.println(sb);
    }

    private static void plus1(int[] help) {
        int zap = 1;
        for (int i = 0; i < help.length; i++) {
            int newZap = (help[i] + zap) / 2;
            help[i] = (help[i] + zap) % 2;
            zap = newZap;
        }
    }

    private static void forMinus1(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
    }
}

/* test1
3 3
1 2 0
1 3 1
2 3 0
*/

/* answer1
-1
011
*/

/* test2
4 6
1 3 0
3 4 0
3 4 1
1 2 1
2 3 1
2 4 0
*/

/* answer2
3
1111
*/
