import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class NotSimple {
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
        int s = nextInt();
        int n = nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i][1] = nextInt();
        }
        Arrays.sort(arr, (o1, o2) -> {
            double res1 = 0;
            double res2 = 0;
            try {
                res1 = 1.0 * o2[1] / o2[0];
            } catch (Exception ignored) {
            }
            try {
                res2 = 1.0 * o1[1] / o1[0];
            } catch (Exception ignored) {
            }
            double res = res1 - res2;
            if (res > 0) return 1;
            if (res < 0) return -1;
            return 0;
        });
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s >= arr[i][0]) {
                ans += arr[i][1];
                s -= arr[i][0];
            } else {
                try {
                    ans += (int) Math.ceil(1.0 * s * arr[i][1] / arr[i][0]);
                    s = 0;
                } catch (Exception ignored) {
                }
            }
        }
        pw.println(ans);
    }
}
