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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    static int m;
    static boolean[][] arr;
    static int countBlack = 0;

    private static void solve() {
        m = nextInt();
        arr = new boolean[2][m];
        String s = nextLine();
        countBlack = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[0][i] = s.charAt(i) == 'B';
            if (arr[0][i]) countBlack++;
        }
        s = nextLine();
        for (int i = 0; i < s.length(); i++) {
            arr[1][i] = s.charAt(i) == 'B';
            if (arr[1][i]) countBlack++;
        }

        for (int i = 0; i < m; i++) {
            if (arr[0][i]) {
                if (draw(0, i, 0)) {
                    pw.println("YES");
                    return;
                }
                break;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            if (arr[0][i]) {
                if (draw(0, i, 0)) {
                    pw.println("YES");
                    return;
                }
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (arr[1][i]) {
                if (draw(1, i, 0)) {
                    pw.println("YES");
                    return;
                }
                break;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            if (arr[1][i]) {
                if (draw(1, i, 0)) {
                    pw.println("YES");
                    return;
                }
                break;
            }
        }
        pw.println("NO");
    }

    private static boolean draw(int x, int y, int cou) {
        if (!arr[x][y]) return false;
        if (arr[x][y]) cou++;
        arr[x][y] = false;
        if (cou == countBlack) return true;

        try {
            if (draw(x - 1, y, cou)) return true;
        } catch (Exception e) {

        }
        try {
            if (draw(x + 1, y, cou)) return true;
        } catch (Exception e) {

        }
        try {
            if (draw(x, y - 1, cou)) return true;
        } catch (Exception e) {

        }
        try {
            if (draw(x, y + 1, cou)) return true;
        } catch (Exception e) {

        }
        arr[x][y] = true;
        return false;
    }
}
