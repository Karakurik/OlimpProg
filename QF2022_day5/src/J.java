import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class J {
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

    static int n;
    static int m;
    static int q;

    private static void solve() {
        n = nextInt();
        m = nextInt();
        q = nextInt();

        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int f = nextInt() - 1;
            int s = nextInt() - 1;
            int g = nextInt();
            int y = nextInt();
            map.put(new Pair(f, s), new Pair(g, y));
            arr[f].add(s);
        }
        dfs(0, 0, 0);
        Pair p1 = answers.stream().min((o1, o2) -> {
            if (o1.s == o2.s) {
                return o2.f - o1.f;
            }
            return o1.s - o2.s;
        }).orElse(answers.get(0));
        Pair p2 = answers.stream().min((o1, o2) -> {
            if (o1.f == o2.f) {
                return o1.s - o2.s;
            }
            return o2.f - o1.f;
        }).orElse(answers.get(0));

        for (int i = 0; i < q; i++) {
            int a = nextInt();
            int b = nextInt();
            boolean flag = p1.f * a > p1.s * b;
            flag |= p2.f * a > p2.s * b;

            pw.println(flag ? "YES" : "NO");
        }
    }

    private static void dfs(int f, int couG, int couY) {
        if (f == n - 1) {
            answers.add(new Pair(couG, couY));
            return;
        }
        for (int s : arr[f]) {
            Pair p = map.get(new Pair(f, s));
            dfs(s, couG + p.f, couY + p.s);
        }
    }


    static List<Integer>[] arr;
    static Map<Pair, Pair> map = new HashMap<>();
    static List<Pair> answers = new ArrayList<>();

    public static class Pair {
        int f;
        int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;

            if (f != pair.f) return false;
            return s == pair.s;
        }

        @Override
        public int hashCode() {
            int result = f;
            result = 31 * result + s;
            return result;
        }
    }
}
