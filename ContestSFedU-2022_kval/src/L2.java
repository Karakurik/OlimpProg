import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class L2 {
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

    static long[][] sum;
    static long[][] arr;
    static int n;
    static int m;
    static long ans = -1;

    private static void solve() {
//        n = 500;
//        m = 500;
//        int h = 20;
//        int w = 200;
//        sum = new long[n + 1][m + 1];
//        arr = new long[n + 1][m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                arr[i][j] = 100000L;
//                sum[i][j] = sum[i - 1][j] - sum[i - 1][j - 1] + sum[i][j - 1] + arr[i][j];
//            }
//        }
        n = nextInt();
        m = nextInt();
        int h = nextInt();
        int w = nextInt();
        sum = new long[n + 1][m + 1];
        arr = new long[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = nextInt();
                sum[i][j] = sum[i - 1][j] - sum[i - 1][j - 1] + sum[i][j - 1] + arr[i][j];
            }
        }
        count(h, w);
//        count(w, h);

        pw.println(ans);
    }

    private static void count(int h, int w) {
        for (int i = h; i <= n; i++) {
            for (int j = w; j <= m; j++) {
                long localSum = sum[i][j] - sum[i - h][j] - sum[i][j - w] + sum[i - h][j - w];
                int sredZn = (int) Math.round(localSum / 1.0 / (h * w));
                long couM1 = 0;
                for (long med = Math.max(sredZn - 1000, 0); med < sredZn + 1000; med++) {
                    couM1 = 0;
                    for (int k = i - h + 1; k <= i; k++) {
                        for (int l = j - w + 1; l <= j; l++) {
                            couM1 += Math.abs(med - arr[k][l]);
                        }
                    }
                    if (ans == -1 || couM1 < ans) ans = couM1;
                }
            }
        }
    }
}
