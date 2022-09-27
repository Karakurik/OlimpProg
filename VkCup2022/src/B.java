import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        long[] mas = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            mas[i] = nextLong();
            sum += mas[i];
        }
        List<Long> sumj = new ArrayList<>();
        sumj.add(0L);
        for (int i = 0; i < n; i++) {
            sumj.add(sumj.get(i) + mas[i]);
        }
        pw.println(0);
        for (long i = 1; i < 100; i++) {
            for (int j = 0; j < n; j++) {
                long l1 = (i * mas[j] + 99L) / 100;
                long r1 = ((i + 1L) * mas[j] - 1L) / 100;
                long l2 = (i * sum - sumj.get(j) * 100L + 99L) / 100;
                long r2 = ((i + 1L) * sum - sumj.get(j) * 100L - 1L) / 100;
                if (l1 <= r1 && l2 <= r2 && ((l1 <= l2 && r1 >= l2) || (l1 >= l2 && r2 >= l1))) {
                    pw.println(i);
                    break;
                }
            }
        }
        pw.println(100);
    }
}
