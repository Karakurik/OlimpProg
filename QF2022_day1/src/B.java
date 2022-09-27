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
        long start = System.currentTimeMillis();
        long n = nextLong();
        List<Pair> answers = new ArrayList<>();
        long a = 2 + 2 * n + 1;
        long p = (2 * a - 4) * (n + 1);
        long q = (a - 2 - 2 * n);
        while (true) {
            if (p / q < a) break;
            if (p % q == 0) {
                answers.add(new Pair(a, p / q));
            }
            a++;
            p += 2 * n + 2;
            q++;
//            if (System.currentTimeMillis() - start > 850) break;
        }
        pw.println(answers.size());

        for (var x : answers) {
            pw.println(x.a + " " + x.b);
        }
    }

    static class Pair {
        long a;
        long b;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }
}
