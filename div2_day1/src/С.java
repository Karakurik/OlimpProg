import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class С {
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

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static char nextChar() {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static int nexInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        solve();
        pw.close();
    }

    private static void solve() {
        int n = nexInt();
        int k = nexInt();
        for (int i = 1; i <= n; i += k + 1) {
            for (int j = i; j < i + k + 1; j++) {

            }
        }

        for (int i = 1; i < n-k; i++) {
            int j;
            for (j = 0; j < k && i+k+1+j <= n; j++) {
                pw.println(i + " " + (i+k+1+j));
            }
            int z = 1;
            while (j+z-1 < k) {
                pw.println(i + " " + (i+z) );
                z++;
            }
        }
    }
}
