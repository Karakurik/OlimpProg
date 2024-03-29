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
        for (int j = 1; j <= t; j++) {
            pw.printf("Case #%d: ", j);
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int p = nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = nextInt();
        }
        int y = 0;
        for (int q = 0; q + (m - 1) * p < n; q++) {
            boolean flag = true;
            for (int i = 0; i < arr2.length; i++) {
                try {
                    if (arr2[i] != arr1[q + i * p]) {
                        flag = false;
                        break;
                    }
                } catch (Exception e) {
                    flag = false;
                    break;
                }
            }
            if (flag) y++;
        }
        pw.println(y);
    }
}
