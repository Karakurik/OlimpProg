import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E {
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
        int n = nextInt();
        Map<Integer, Integer> a = new HashMap<>();
        Map<Integer, Integer> b = new HashMap<>();
        boolean[] used = new boolean[1_000_00];
        List<Integer> prost = new ArrayList<>();
        for (int i = 2; i < used.length; i++) {
            if (!used[i]) {
                prost.add(i);
                for (int j = 2 * i; j < used.length; j += i) {
                    used[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            for (int j = 0; j < prost.size(); j++) {
                int p = prost.get(j);
                while (t % p == 0) {
                    t /= p;
                    if (a.containsKey(p)) {
                        a.put(p, a.get(p)+1);
                    } else {
                        a.put(p, 1);
                    }
                }
                if (t == 1) break;
            }
            if (a.containsKey(t)) {
                a.put(t, a.get(t)+1);
            } else {
                a.put(t, 1);
            }
        }

        int m = nextInt();
        for (int i = 0; i < m; i++) {
            int t = nextInt();
            for (int j = 0; j < prost.size(); j++) {
                int p = prost.get(j);
                while (t % p == 0) {
                    t /= p;
                    if (b.containsKey(p)) {
                        b.put(p, b.get(p)+1);
                    } else {
                        b.put(p, 1);
                    }
                }
                if (t == 1) break;
            }
            if (b.containsKey(t)) {
                b.put(t, b.get(t)+1);
            } else {
                b.put(t, 1);
            }
        }

        long ans = 1L;
        boolean flag = false;
        for (Map.Entry<Integer, Integer> entry: a.entrySet()) {
            if (b.containsKey(entry.getKey())) {
                int c = Math.min(entry.getValue(), b.get(entry.getKey()));
                for (int j = 0; j < c; j++) {
                    ans = (ans * entry.getKey());
                    if (String.valueOf(ans).length()>9) flag=true;
                    ans %= 1_000_000_000L;
                }
            }
        }

        for (int i = 0; i < 9 - String.valueOf(ans).length() && flag; i++) {
            pw.print(0);
        }
        pw.println(ans);

    }

}