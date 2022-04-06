import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G {
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
        long b = nextLong();
        long r = nextLong();
        long kub = b + r;
        long mMax = (long) Math.pow(kub, 0.34);
        long ans = 0;
        for (int m = 1; m <= mMax; m++) {
            long tempKub = kub;
            if (tempKub % m == 0) {
                tempKub /= m;
                long nMax = (long) Math.sqrt(tempKub);
                for (int n = m; n <= nMax; n++) {
                    if (tempKub % n == 0) {
                        long k = tempKub / n;
                        if (k < n) break;
                        long vnutKub = vnutKub(m, n, k);
                        if (vnutKub==-1) {
                            if (b==0||r==0) ans++;
                        } else {
                            if (vnutKub >= b) ans++;
                            if (vnutKub >= r) ans++;
                        }
                    }
                }
            }
        }
        pw.println(ans);
    }

    private static long vnutKub(long a, long b, long c) {
        if (a < 3 || b < 3 || c < 3) return -1;
        return (a - 2) * (b - 2) * (c - 2);
    }
}
