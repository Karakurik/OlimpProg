import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
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
        if (n == 1) {
            pw.println(4);
            pw.println("1 1 1 1");
            return;
        }

        if (n <= 4) {
            int ans = (n - 2) * 2 + 2 * 4;
            pw.println(ans);
            for (int i = 1; i <= n; i++) {
                int k = 2;
                if (i == 1 || i == n) k = 4;
                for (int j = 0; j < k; j++) {
                    pw.print(i + " ");
                }
            }
            pw.println();
        } else {
            int ans = (n - 4) + 2 * 2 + 2 * 4;
            pw.println(ans);
            for (int i = 1; i <= n; i++) {
                int k = 1;
                if (i == 1 || i == n) k = 4;
                if (i == 2 || i == n - 1) k = 2;
                for (int j = 0; j < k; j++) {
                    pw.print(i + " ");
                }
            }
            pw.println();
        }
    }
}
