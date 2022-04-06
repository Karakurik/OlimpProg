import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();

        int A = 1_000_000_001;
        int mL = A;
        int mR = 0;
        int mLen = 0;
        int cL = A;
        int cR = A;
        int cLen = A;

        for (int i = 0; i < n; i++) {
            int l = nextInt();
            int r = nextInt();
            int c = nextInt();

            if (l < mL || l == mL && c < cL) {
                mL = l;
                cL = c;
            }
            if (r > mR || r == mR && c < cR) {
                mR = r;
                cR = c;
            }

            if (r - l + 1 > mLen || r - l + 1 == mLen && c < cLen) {
                mLen = r - l + 1;
                cLen = c;
            }

            if (mR - mL + 1 == mLen) {
                pw.println(Math.min(cLen, cL + cR));
            } else {
                pw.println(cL + cR);
            }
        }
    }
}
