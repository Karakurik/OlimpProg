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
        int a = nextInt();
        int b = nextInt();
        if (!check(n, a, b)) {
            pw.println(-1);
        } else {
            int l = 1;
            int r = n;
            int k;
            if (a>b) {
                k = a;
                for (int i = 0; i < k; i++) {
                    pw.print(l++ + " ");
                    pw.print(r-- + " ");
                }
                for (int i = r; i >= l; i--) {
                    pw.print(i + " ");
                }
                pw.println();
            } else if (b > a) {
                k=b;
                for (int i = 0; i < k; i++) {
                    pw.print(r-- + " ");
                    pw.print(l++ + " ");
                }
                for (int i = l; i <=r; i++) {
                    pw.print(i + " ");
                }
                pw.println();
            } else {
                k=a;
                for (int i = 0; i < k; i++) {
                    pw.print(r-- + " ");
                    pw.print(l++ + " ");
                }
                for (int i = r; i >= l; i--) {
                    pw.print(i + " ");
                }
                pw.println();
            }
        }

    }

    private static boolean check(int n, int a, int b) {
        if (a-b>1) return false;
        if (b-a>1) return false;
        if (b+a > n-2) return false;
        return true;
    }

}