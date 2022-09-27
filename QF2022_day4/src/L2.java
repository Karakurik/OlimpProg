import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class L2 {
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

    static boolean[][] arr;

    static int n;
    static int m;

    private static void solve() {
        n = nextInt();
        m = nextInt();
        arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) == '#';
            }
        }

        int couQ = 0, couF = 0;
//        for (int i = 0; i < n - 4; i++) {
//            for (int j = 0; j < m - 2; j++) {
//                if (arr[i][j] && arr[i + 1][j] && arr[i + 1][j] && arr[i][j + 1] && arr[i + 2][j + 1] && arr[i][j + 2]) {
//                    if (arr[i + 3][j] && arr[i + 4][j]) {
//                        couF++;
//                    } else if (arr[i + 1][j + 2] && arr[i + 2][j + 2] && arr[i + 3][j + 2] && arr[i + 4][j + 2]) {
//                        couQ++;
//                    }
//                }
//            }
//        }
        detekt(0, 0, 0, 0);
    }


    public static boolean detekt(int i, int j, int couF, int couQ) {
        if (arr[i][j]) {
            boolean f = detektF(i, j);
            boolean q = detektQ(i, j);
            if (!(f || q)) return false;
            if (f) {
                draw(true, false, i, j);
                detektNext(i, j, couF + 1, couQ);
                draw(true, true, i, j);
            }
            if (q) {
                draw(false, false, i, j);
                detektNext(i, j, couF, couQ + 1);
                draw(false, true, i, j);
            }
        } else {
            detektNext(i, j, couF, couQ);
        }
        return true;
    }

    public static void detektNext(int i, int j, int couF, int couQ) {
        if (i == n - 5 && j == m - 3) {
            for (int k = i; k < n; k++) {
                for (int l = j; l < m; l++) {
                    if (arr[k][l]) {
                        return;
                    }
                }
            }
            pw.println(couQ + " " + couF);
            pw.close();
            System.exit(0);
        } else {
            j++;
            if (j == m) {
                i++;
                j = 0;
            }
            try {

                detekt(i, j, couF, couQ);
            } catch (Exception e) {
                pw.println(couQ + " " + couF);
                pw.close();
                System.exit(0);
            }
        }
    }

    public static boolean detektF(int i, int j) {
        if (arr[i][j] && arr[i + 1][j] && arr[i + 1][j] && arr[i][j + 1] && arr[i + 2][j + 1] && arr[i][j + 2]) {
            if (arr[i + 3][j] && arr[i + 4][j]) {
                return true;
            }
        }
        return false;
    }

    public static boolean detektQ(int i, int j) {
        if (arr[i][j] && arr[i + 1][j] && arr[i + 1][j] && arr[i][j + 1] && arr[i + 2][j + 1] && arr[i][j + 2]) {
            if (arr[i + 1][j + 2] && arr[i + 2][j + 2] && arr[i + 3][j + 2] && arr[i + 4][j + 2]) {
                return true;
            }
        }
        return false;
    }

    public static void draw(boolean isF, boolean flag, int i, int j) {
        arr[i][j] = flag;
        arr[i + 1][j] = flag;
        arr[i + 2][j] = flag;
        arr[i][j + 1] = flag;
        arr[i + 2][j + 1] = flag;
        arr[i][j + 2] = flag;

        if (isF) {
            arr[i + 3][j] = flag;
            arr[i + 4][j] = flag;
        } else {
            arr[i + 1][j + 2] = flag;
            arr[i + 2][j + 2] = flag;
            arr[i + 3][j + 2] = flag;
            arr[i + 4][j + 2] = flag;
        }
    }
}
