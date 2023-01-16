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
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] used;
    static boolean[] usedBukva;

    private static void solve() {
        n = nextInt();
        m = nextInt();
        arr = new int[n][m];
        used = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            for (int j = 0; j < m; j++) {
                int t = s.charAt(j) - 'A';
                if ((i + j) % 2 == 0) {
                    arr[i][j] = t;
                } else {
                    arr[i][j] = -1;
                }
            }
        }

        usedBukva = new boolean[26];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != -1 && !used[i][j]) {
                    if (usedBukva[arr[i][j]]) {
                        pw.println("NO");
                        return;
                    } else {
                        usedBukva[arr[i][j]] = true;
                        add(i, j, arr[i][j]);
                    }
                }
            }
        }
        pw.println("YES");
    }

    private static void add(int i, int j, int bukva) {
        if (i < 0 || i >= n || j < 0 || j >= m) return;
        if (arr[i][j] != bukva) return;
        if (used[i][j]) return;

        used[i][j] = true;
        add(i, j - 2, bukva);
        add(i, j + 2, bukva);
        add(i - 1, j - 1, bukva);
        add(i - 1, j + 1, bukva);
        add(i + 1, j - 1, bukva);
        add(i + 1, j + 1, bukva);
    }
}
