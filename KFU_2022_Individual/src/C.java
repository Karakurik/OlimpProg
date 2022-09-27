import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
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
        long n = nextLong();
        long k = nextLong();
        if (n * (n - 1) / 2 < k) {
            pw.println("No");
            return;
        }

        pw.println("Yes");
        long reserved = -1;
        boolean[] used = new boolean[(int) (n + 1)];
        int usedId = 1;
        for (int i = 1; i <= n; i++) {
            if (k != 0 && k >= n - i) {
                pw.println(i + " " + (n - i + 1));
                k -= n - i;
                used[(int) (n - i + 1)] = true;
            } else if (k > 0) {
                reserved = k + 1;
                pw.println(i + " " + reserved);
                used[(int) reserved] = true;
                k = 0;
            } else {
                while (used[usedId]) usedId++;
                used[usedId] = true;
                pw.println(i + " " + usedId);
            }
        }
    }
}
