import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int size = 26;
        long couAA = 0;
        long lenA = 0;
        long lenB = 0;
        int q = nextInt();
        boolean globalFlag = false;
        for (int i = 0; i < q; i++) {
            if (nextInt() == 1) {
                long cou = nextInt();
                char[] x = nextToken().toCharArray();
                lenA += x.length * cou;
                for (char c: x) {
                    if (c=='a') couAA += cou;
                }
            } else {
                long cou = nextInt();
                char[] x = nextToken().toCharArray();
                lenB += x.length * cou;
                for (char c : x) {
                    if (c != 'a') {
                        globalFlag = true;
                    }
                }
            }
            long temp = Math.min(couAA, lenB);
            lenB -= temp;
            lenA -= temp;
            couAA -= temp;
            if (!globalFlag && (lenB >= couAA && lenA != couAA || lenB <= couAA)) {
                pw.println("NO");
            } else {
                pw.println("YES");
            }
        }
    }
}
