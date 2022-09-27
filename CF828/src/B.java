import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
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
        int q = nextInt();
        long answer = 0;
        int[] cou = new int[2];
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            answer += t;
            cou[t % 2]++;
        }
        for (int i = 0; i < q; i++) {
            int type = nextInt();
            int x = nextInt();
            if (type == 0) {
                answer += (long) cou[0] * x;
                if (x % 2 == 1) {
                    cou[1] += cou[0];
                    cou[0] = 0;
                }
            } else {
                answer += (long) cou[1] * x;
                if (x % 2 == 1) {
                    cou[0] += cou[1];
                    cou[1] = 0;
                }
            }
            pw.println(answer);
        }
    }
}
