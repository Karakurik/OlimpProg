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

    static ArrayList<Long> kv = new ArrayList<>();
    private static final long E12 = 1_000_000_000_000L;

    private static void solve() {

        for (long i = 1; i < 1_000_001; i++) {
            long t = i * (i + 1);
            if (t > E12) break;
            kv.add(t);
            cache.put(t, 1L);
        }
        long n = nextLong();
        pw.println(count(n, 0));
    }

    static HashMap<Long, Long> cache = new HashMap<>();

    private static long count(long n, long ans) {
        int id = Collections.binarySearch(kv, n);
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        id = - id - 2;
        long cou = Long.MAX_VALUE;
        for (int i = id; i >= 0 && kv.get(i) >= n - kv.get(i); i--) {
            cou = Math.min(cou, count(n - kv.get(i), ans + 1));
            if (cou == 2) break;
        }
        cache.put(n, cou + 1);
        return cou + 1;
    }
}
