import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class I {
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
        int m = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        TreeSet<Pair> set = new TreeSet<>(Comparator.comparingInt(o -> o.c));

        for (int i = 0; i < n; i++) {
            set.add(new Pair(i, arr[i]));
        }

        TreeMap<Integer, List<Pair>> time = new TreeMap<>();

        long ans = 0;

        for (int i = 0; i < m; i++) {
            int t = nextInt();
            int l = nextInt();
            while (!time.isEmpty() && time.firstKey() <= t) {
                set.addAll(time.pollFirstEntry().getValue());
            }
            try {
                ans += (long) set.first().c * l;
                if (!time.containsKey(t + l)) time.put(t + l, new ArrayList<>());
                time.get(t + l).add(set.pollFirst());
            } catch (Exception ignored) {

            }
        }
        pw.println(ans);
    }

    public static class Pair {
        int name;
        int c;

        public Pair(int name, int c) {
            this.name = name;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;

            if (name != pair.name) return false;
            return c == pair.c;
        }

        @Override
        public int hashCode() {
            int result = name;
            result = 31 * result + c;
            return result;
        }
    }

}
