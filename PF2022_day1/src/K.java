import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class K {
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
        int t = nextInt();
        test = t;
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    static int test;

    private static void solve() {
        long start = System.currentTimeMillis();
        long n = nextLong();
        List<Integer> list = new ArrayList<>();
        int divider = 1;
        while (n > 0) {
            divider++;
            list.add((int) (n % divider));
            n /= divider;
        }
        int SIZE = Collections.max(list) + 1;
        int[] div = new int[SIZE];
        for (int i : list) {
            div[i]++;
        }
        long ans = 0;

        for (int h = SIZE - 1; h > 0; h--) {
            if (div[h] == 0) continue;

            div[h]--;
            int used = 1;
            long localAns = 1;
            boolean flag = true;
            for (int i = SIZE - 1; i >= 0; i--) {
                if (div[i] == 0) continue;
                int m = div[i];
                int k = divider - i - used;
                if (k < m) {
                    flag = false;
                    break;
                }
                long c = 1L;
                for (int j = 1; j <= k; j++) {
                    c *= j;
                }
                for (int j = 1; j <= m; j++) {
                    c /= j;
                }
                for (int j = 1; j <= k - m; j++) {
                    c /= j;
                }
                used += div[i];
                if (used != divider - 1) localAns *= c;
            }
            if (flag) {
                ans += localAns;
            }
            div[h]++;
        }

        pw.println(ans - 1);
    }
}
