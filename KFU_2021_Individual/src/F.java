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
        int x1 = nextInt();
        int y1 = nextInt();
        int x2 = nextInt();
        int y2 = nextInt();
        int a = nextInt();
        int b = nextInt();
        int[][] ans = new int[5][3];
        int answer = -1;
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = Math.abs(x2-x1);
            ans[i][1] = Math.abs(y2-y1);
        }
        ans[0][2] = 0;
        ans[1][0] += b;
        ans[1][1] += b;
        ans[1][2] = 1;
        ans[2][0] += b;
        ans[2][1] -= b;
        ans[2][2] = 1;
        ans[3][0] -= b;
        ans[3][1] += b;
        ans[3][2] = 1;
        ans[4][0] -= b;
        ans[4][1] -= b;
        ans[4][2] = 1;
        for (int i = 0; i < ans.length; i++) {
            if (ans[i][0] % a == 0 && ans[i][1] % a == 0) {
                int cou1 = ans[i][0] / a;
                int cou2 = ans[i][1] / a;
                if ((cou1 - cou2) % 2 == 0) {
                    if (answer == -1 || answer > Math.max(cou1, cou2) + ans[i][2]) {
                        answer = Math.max(cou1, cou2) + ans[i][2];
                    }
                }
            }
        }
        pw.println(answer);
    }
}
