import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class M {
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
        long n = nextLong();
        long a = nextLong();
        long b = nextLong();
        long c = nextLong();
        long d = nextLong();
        long l = 1L;
        long r = n;
        long ansCand = n;
        while (l <= r) {
            long m = (l + r) / 2;
            long curN = n - m;
            if (curN > 0) {
                curN -= m / (a + b) * a + Math.min(a, m % (a + b));
                if (curN > 0) {
                    curN -= m / (c + d) * c + Math.min(c, m % (c + d));
                }
            }
            if (curN <= 0) {
                if (m < ansCand) {
                    ansCand = m;
                }
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        pw.println(ansCand);
    }
}
