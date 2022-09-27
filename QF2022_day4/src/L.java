import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class L {
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
        int m = nextInt();
        boolean[][] arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) == '#';
            }
        }

        int couQ = 0, couF = 0;
        for (int j = 0; j < m - 2; j++) {
            for (int i = 0; i < n - 4; i++) {
                if (arr[i][j] && arr[i + 1][j] && arr[i + 2][j] && arr[i][j + 1] && arr[i + 2][j + 1] && arr[i][j + 2]) {
                    if (arr[i + 3][j] && arr[i + 4][j]) {
                        couF++;
                    } else if (arr[i + 1][j + 2] && arr[i + 2][j + 2] && arr[i + 3][j + 2] && arr[i + 4][j + 2]) {
                        couQ++;
                    }
                }
            }
        }
        pw.println(couQ + " " + couF);
    }
}
