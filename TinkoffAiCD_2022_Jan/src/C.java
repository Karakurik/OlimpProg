import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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

    private static void solve() {
        Pair pair0 = new Pair(1, 1);
        Pair pair1 = new Pair(1, 2);
        for (char c: nextLine().toCharArray()) {
            if (c == '0') {
                pw.println(pair0);
                pair0 = nextPair0(pair0);
            } else {
                pw.println(pair1);
                pair1 = nextPair1(pair1);
            }
        }
    }

    static Pair nextPair0(Pair p) {
        if (p.x == 1) return new Pair(3, p.y);
        return new Pair(1, p.y);
    }

    static Pair nextPair1(Pair p) {
        if (p.x < 4) return new Pair(p.x+1, p.y);
        return new Pair(1, p.y);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }
}
