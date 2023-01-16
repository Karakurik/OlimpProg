import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Task5mba {
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

    static int n;

    private static void solve() {
        long time = System.currentTimeMillis();
        n = nextInt();
        int m = nextInt();

        if (n <= 8) {
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

            long iters = (long) Math.pow(2, n);

            int[] help = new int[n];

            int ans = -1;
            StringBuilder sb = new StringBuilder();

            for (long i = 1; i < iters; i++) {
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
        } else {
            g = new List[n * 2];
            for (int i = 0; i < g.length; i++) {
                g[i] = new ArrayList<>();
            }
            d = new int[n * 2];
            p = new int[n * 2];

            for (int i = 0; i < m; i++) {
                int a = nextInt() - 1;
                int b = nextInt() - 1;
                int c = nextInt();
                if (c == 0) {
                    g[a].add(b);
                    g[a].add(b + n);
                } else {
                    g[a + n].add(b);
                    g[a + n].add(b + n);
                }
            }

            saveAns(0);
            saveAns(1);

            pw.println(answer);
        }
    }

    public static void saveAns(int s) {
        for (int i = 0; i < d.length; i++) {
            d[i] = mod;
            p[i] = -1;
        }

        d[s] = 0;
        TreeSet<Pair> q = new TreeSet<>();
        q.add(new Pair(d[s], s));
        while (!q.isEmpty()) {
            int v = q.first().second;
            q.remove (q.first());

            for (var j = 0; j < g[v].size(); ++j) {
                int to = g[v].get(j), len = 1;
                if (d[v] + len < d[to]) {
                    q.remove(new Pair(d[to], to));
                    d[to] = d[v] + len;
                    p[to] = v;
                    q.remove(new Pair(d[to], to));
                }
            }
        }

        answer = Math.max(answer, Math.min(d[n - 1], d[n * 2 - 1]));
    }

    static class Pair implements Comparable<Pair> {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;

            if (first != pair.first) return false;
            return second == pair.second;
        }

        @Override
        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            return result;
        }

        @Override
        public int compareTo(Pair o) {
            if (first == o.first) return second - o.second;
            return first - o.second;
        }
    }

    private static final int mod = 1_000_000_007;
    static int answer = 0;

    static int[] d;
    static int[] p;
    static List<Integer>[] g;

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
