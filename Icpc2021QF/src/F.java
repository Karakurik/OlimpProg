import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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

    private static void solve() {
        long time = System.currentTimeMillis();
        int n = nextInt();
        HashSet<Integer>[] sets = new HashSet[33];
        int e = 1_000_000_000;
        for (int x = 2; x < 33; x++) {
            sets[x] = new HashSet<>();
            long t = x;
            while (t <= e) {
                sets[x].add((int) t);
                t *= x;
            }
        }
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + t);
            } else {
                map.put(t, (long) t);
            }
            for (int j = 2; j < 33; j++) {
                if (sets[j].contains(t)) {
                    if (j!=t) {
                        if (map.containsKey(j)) {
                            map.put(j, map.get(j) + t);
                        } else {
                            map.put(j, (long) t);
                        }
                    }

                }
            }
        }
        long ans = 0;
        for (HashMap.Entry<Integer, Long> el: map.entrySet()) {
            ans = Math.max(ans, el.getValue());
        }
        pw.println(ans);
    }
}