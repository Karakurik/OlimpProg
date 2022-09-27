import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D {
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

    private static void solve() {
        int h = nextInt();
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        int l = 0;
        int r = Integer.MAX_VALUE;
        int ans = 0;
        while (l <= r) {
            int m = (l + r)/2;
            int t = m;
            int cou = 0;
            for (int i = 0; i < n; i++) {
                t -= arr[i];
                if (t <= 0) {
                    t = m;
                    cou++;
                    if (cou>=h) break;
                }
            }
            if (cou>=h) {
                ans = Math.max(ans, m);
                l = m + 1;
            } else {
                r = m-1;
            }
        }
        pw.println(ans);
    }
}
