import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P {
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

    static LinkedList<Pair> list;

    private static void solve() {
        int n = nextInt();
        long k = nextLong();
        String s = nextLine();
        long cou = 0;
        long localCou = 0;
        list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                localCou = localCou * 10 + Character.getNumericValue(c);
            } else {
                if (localCou == 0) localCou = 1;
                cou += localCou;
                list.add(new Pair(c, localCou));
                localCou = 0;
            }
        }
        k %= cou;

        while (k > 0) {
            if (k >= list.getFirst().cou) {
                add(list.getFirst());
                k -= list.getFirst().cou;
                list.removeFirst();
            } else {
                list.getFirst().cou -= k;
                add(new Pair(list.getFirst().c, k));
                k = 0;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Pair p: list) {
            if (p.cou > 1) {
                ans.append(p.cou);
            }
            ans.append(p.c);
        }
        pw.println(ans);
    }

    public static void add (Pair p) {
        if (list.getLast().equals(p)) {
            list.getLast().cou += p.cou;
        } else {
            list.add(p);
        }
    }

    private static class Pair {
        char c;
        long cou;

        public Pair(char c, long cou) {
            this.c = c;
            this.cou = cou;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            return c == pair.c;
        }

        @Override
        public int hashCode() {
            return c;
        }
    }
}
