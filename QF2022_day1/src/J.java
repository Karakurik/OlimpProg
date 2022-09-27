import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class J {
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

        int n = nextInt();
        long[] sums = new long[n];
        long[] a = new long[n];
        long[] b = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }

        for (int i = 0; i < n; i++) {
            b[i] = nextLong();
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sums[i] = (a[i] - b[i]) * (a[i] - b[i]);
            } else {
                sums[i] = sums[i - 1] + (a[i] - b[i]) * (a[i] - b[i]);
            }
        }

        long m = nextLong();

        for (int i = 0; i < m; i++) {
            int a1 = nextInt();
            int b1 = nextInt();
            double kek = 0;
            if (a1 - 2 >= 0)
                kek = sums[a1 - 2];
            pw.println(Math.sqrt(sums[b1 - 1] - kek));
        }
    }
}
