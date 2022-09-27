import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class K {
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
        int k = nextInt();
        if (n == 1 && k == 1) {
            pw.println("YES");
            pw.println(0);
            return;
        }
        if (n == 2 && k == 1) {
            pw.println("YES");
            pw.println(1);
            pw.println("1 2");
            return;
        }
        if (k >= n) {
            pw.println("NO");
            return;
        }
        int count = 0;
        for (int i = 1; i <= n - k; i++) {
            for (int j = i + 1; j <= n; j++) {
                count++;
            }
        }
        int witout = 1;
        for (int i = n - k + 1; i <= n; i++) {
            for (int j = i + 1; j <= n - witout; j++) {
                count++;
            }
            witout++;
        }
        pw.println("YES");
        pw.println(count);
        for (int i = 1; i <= n - k; i++) {
            for (int j = i + 1; j <= n; j++) {
                pw.printf("%d %d\n", i, j);
            }
        }
        witout = 1;
        for (int i = n - k + 1; i <= n; i++) {
            for (int j = i + 1; j <= n - witout; j++) {
                pw.printf("%d %d\n", i, j);
            }
            witout++;
        }
    }
}
