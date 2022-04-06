import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
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
        int n = nextInt();
        int m = nextInt();
        if (m > n) {
            int t = n;
            n = m;
            m = t;
        }
        int k = n - m;
        if (k >= m) {
            pw.println(0);
            return;
        }
        if (k + 1 == m) {
            pw.println(1);
            return;
        }
        if ((m - 1 - k) % 3 == 0) {
            int k1 = (m - 1 - k) / 3;
            int k2 = k+k1;
            k = k1+k2;
            long ans = 1;
            if (k1<k-k1) k1 = k-k1;
            int i1 = k1+1;
            int i2 = 2;
            while (i1<=k) {
                ans *= i1++;
                while (i2<=k1 && ans%i2==0) {
                    ans /= i2++;
                }
            }
            pw.println(ans);
        } else {
            pw.println(0);
        }
    }
}