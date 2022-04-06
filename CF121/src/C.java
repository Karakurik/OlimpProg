import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        class Range {
            int l;
            int r;

            public Range(int l, int r) {
                this.l = l;
                this.r = r;
            }
        }
        int n = nextInt();
        int[] k = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            k[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            h[i] = nextInt();
        }
        List<Range> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Range(k[i] - h[i], k[i]));
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.l));
        int l = list.get(0).l;
        int r = list.get(0).r;
        Long ans = 0L;
        for (Range range : list) {
            if (range.l >= r) {
                long len = r-l;
                ans += (len*(len+1))/2;
                l = range.l;
                r = range.r;
            } else {
                if (range.r > r) {
                    r = range.r;
                }
            }
        }
        long len = r-l;
        ans += (len*(len+1))/2;
        pw.println(ans);
    }
}
