import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
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

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static void solve() {
        int n = nextInt();
        long[] s = new long[n];
        long[] p = new long[n];
        for (int i = 0; i < n; i++) {
            s[i] = nextLong();
        }
        for (int i = 0; i < n; i++) {
            p[i] = nextLong();
        }

        long nod = p[0];
        for (int i = 1; i < n; i++) {
            nod = gcd(nod, p[i]);
        }
        for (int i = 0; i < n; i++) {
            p[i] /= nod;
        }


        long l = 1;
        long r = Integer.MAX_VALUE / Arrays.stream(p).max().getAsLong();
        long ansValue = Long.MAX_VALUE;
        long ans = Long.MAX_VALUE;
        while (l <= r) {
            long m1 = l + (r - l) / 3;
            long m2 = r - (r - l) / 3;
            long cou1 = 0;
            long cou2 = 0;
            for (int i = 0; i < n; i++) {
                cou1 += Math.abs(p[i] * m1 - s[i]);
                cou2 += Math.abs(p[i] * m2 - s[i]);
            }
            if (cou1 > cou2) {
                l = m1 + 1;
                if (ansValue > cou1) {
                    ansValue = cou1;
                    ans = m1;
                }
            } else {
                r = m2 - 1;
                if (ansValue > cou2) {
                    ansValue = cou2;
                    ans = m2;
                }
            }
        }
        pw.println(ansValue);
    }
}
