import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

    static int sum = -1;
    static int[] ball;
    static boolean[] used;
    static int[][] p;

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        ball = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ball[i] = nextInt();
        }
        p = new int[n + 1][2];
        for (int i = 0; i < m; i++) {
            int t = nextInt();
            p[t][0] = nextInt();
            p[t][1] = nextInt();
        }
        used = new boolean[n + 1];
        calc(n, 0);
        if (sum == -1) {
            pw.println("No");
        } else {
            pw.println(sum);
        }
    }

    private static void calc(int n, int localSum) {
        localSum += ball[n];
        if (n == 1) {
            if (localSum > sum) sum = localSum;
        }

        used[n] = true;
        for (int i = 1; i < n; i++) {
            if (used[i]) continue;

            if (p[i][0] <= n && p[i][1] >= n) {
                calc(i, localSum);
            }
        }
        used[n] = false;
    }


}
