import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A3 {
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
        int n = nextInt();
        int m = nextInt();
        boolean[][][] arr = new boolean[n][m][m];
        for (int i = 0; i < n; i++) {
            char[] s = nextLine().toCharArray();
            for (int j = 0; j < s.length; j++) {
                arr[i][j / m][j % m] = s[j] == '0';
            }
        }

        int ans = n + 1;
        int ansL = -2, ansR = -2;
        for (int i = 0; i < n; i++) {
            boolean[][] set = new boolean[m][m];
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    set[j][k] = arr[i][j][k];
                    flag &= set[j][k];
                }
            }
            if (flag) {
                pw.printf("%d %d\n", i + 1, i + 1);
                return;
            }

            for (int r = i + 1; r < n; r++) {
//                pw.printf("noans %d %d\n", i, r);
                if (ans <= r - i + 1) break;

                boolean[][] newSet = new boolean[m][m];
                boolean globalFalg = true;
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < m; k++) {
                        flag = true;
                        for (int l = 0; l < m; l++) {
                            flag &= (set[j][l] || arr[r][l][k]);
                        }
                        newSet[j][k] = flag;
                        globalFalg &= flag;
                    }
                }

                if (globalFalg) {
                    if (ans > r - i + 1) {
                        ans = r - i + 1;
                        ansL = i;
                        ansR = r;
                    }
                }
                set = newSet;
            }
        }
        pw.printf("%d %d\n", ansL + 1, ansR + 1);
    }
}
