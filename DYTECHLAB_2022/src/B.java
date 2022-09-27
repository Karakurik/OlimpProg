import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
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

    static List<Long> list;
    static Map<Long, Long> map;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = 1;

//        list = new ArrayList<>();
//        map = new HashMap<>();
//        map.put(0L, 0L);
//
//        for (long i = 1; i < 1_000_000_000; i++) {
//            long next = (i + 1) * (i + 1);
//            long cur = i * i;
//            map.put(next - 1, (next - cur) / i);
//        }
//        map.put(1_000_000_000_000_000_000L, map.get(999_999_999_999_999_999L) + 1);
//        pw.println(list.toString());
        t = nextInt();
        while (t-- > 0) {

            solve();
        }
        pw.close();
    }

    private static void solve() {
        long l = nextLong();
        long r = nextLong();
        long rSqrt = (long) Math.floor(Math.sqrt(r));
        long lSqrt = ((long) Math.floor(Math.sqrt(l)));
        if (rSqrt * rSqrt > r) rSqrt--;
        if (lSqrt * lSqrt > l) lSqrt--;
        if ((rSqrt + 1) * (rSqrt + 1) <= r) rSqrt++;
        if ((lSqrt + 1) * (lSqrt + 1) <= l) lSqrt++;
        long rCount = (rSqrt - 1) * 3;
        long lCount = (lSqrt - 1) * 3;
        for (long i = rSqrt * rSqrt; i < Long.MAX_VALUE; i += rSqrt) {
            if (i > r) break;
            rCount++;
        }
        for (long i = lSqrt * lSqrt; i < Long.MAX_VALUE; i += lSqrt) {
            if (i >= l) break;
            lCount++;
        }
        pw.println(rCount - lCount);
    }
}
