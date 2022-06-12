import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Kubik {
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

    static double a;
    static double b;
    static double c;
    static double d;

    private static void solve() {
        a = nextDouble();
        b = nextDouble();
        c = nextDouble();
        d = nextDouble();
        double l = Float.MIN_VALUE;
        double r = Float.MAX_VALUE;
        double m = (l + r) / 2;
        double ans = m;
        double ansRes = calc(m);
        while (r - l > 0) {
            m = (l + r) / 2;
            double res = calc(m);
            if (res < ansRes) {
                ansRes = res;
                ans = m;
            }
            if (res == 0) break;
            if (res >= 0) {
                r = m;
            } else {
                l = m;
            }
        }
        pw.println(ans);
    }

    private static double calc(double x) {
        return ((a * x + b) * x + c) * x + d;
    }
}
