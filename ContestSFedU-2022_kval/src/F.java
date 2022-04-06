import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {
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

    static int[][] arr;
    static int n;
    static int m;

    private static void solve() {
        n = nextInt();
        m = nextInt();
        arr = new int[12][4];
        arr[0][0] = 0;
        arr[0][1] = -3;
        arr[0][2] = 3;
        arr[0][3] = 0;
        arr[1][0] = 1;
        arr[1][1] = -2;
        arr[1][2] = 2;
        arr[1][3] = -1;
        arr[2][0] = 2;
        arr[2][1] = -2;
        arr[2][2] = 2;
        arr[2][3] = 0;
        arr[3][0] = 1;
        arr[3][1] = -1;
        arr[3][2] = 4;
        arr[3][3] = 0;
        arr[4][0] = 2;
        arr[4][1] = -1;
        arr[4][2] = 2;
        arr[4][3] = -1;
        arr[5][0] = 2;
        arr[5][1] = 0;
        arr[5][2] = 2;
        arr[5][3] = -2;
        arr[6][0] = 3;
        arr[6][1] = 0;
        arr[6][2] = 3;
        arr[6][3] = 0;
        arr[7][0] = 4;
        arr[7][1] = 0;
        arr[7][2] = 1;
        arr[7][3] = -1;
        arr[8][0] = 3;
        arr[8][1] = 0;
        arr[8][2] = 2;
        arr[8][3] = -1;
        arr[9][0] = 2;
        arr[9][1] = -1;
        arr[9][2] = 3;
        arr[9][3] = 0;
        arr[10][0] = 1;
        arr[10][1] = -2;
        arr[10][2] = 3;
        arr[10][3] = 0;
        arr[11][0] = 0;
        arr[11][1] = -3;
        arr[11][2] = 2;
        arr[11][3] = -1;

        long ans = 0;
        long akkum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 2 && i < n - 4 && j > 1 && j < m - 4) {
                    akkum += m - 4 - j;
                    j = m - 5;
                } else {
                    ans += count(i, j);
                }
            }
        }

        if (akkum > 0) {
            ans += 12L * akkum;
        }
        pw.println(ans);
    }

    private static long count(int i, int j) {
        int cou = 0;
        for (int[] e : arr) {
            if (i + e[0] >= 0 && i + e[0] < n &&
                    i + e[1] >= 0 && i + e[1] < n &&
                    j + e[2] >= 0 && j + e[2] < m &&
                    j + e[3] >= 0 && j + e[3] < m) cou++;
        }
        return cou;
    }
}
