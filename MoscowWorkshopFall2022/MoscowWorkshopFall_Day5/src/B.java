import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
        t = nextInt();
        for (int j = 1; j <= t; j++) {
            pw.printf("Case #%d: ", j);
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        allA = new int[n];
        allB = new int[n];
        for (int i = 0; i < n; i++) {
            allA[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            allB[i] = nextInt();
        }
        Huiny result = new Huiny(allB[n-1], allA[n-1]);
        for (int i = n-2; i >=0 ; i--) {
            result = Huiny.divide(allB[i], Huiny.sum(new Huiny(allA[i], 1), result));
        }

        int g = gcd(result.p, result.q);
        result.p = result.p/g;
        result.q = result.q/g;
        pw.println(result.p + " " + result.q);
    }

    public static int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }

    static int[] allA;
    static int[] allB;

    static class Huiny {
        int p;
        int q;

        public Huiny(int p, int q) {
            this.p = p;
            this.q = q;
        }


        public static Huiny sum(Huiny a, Huiny b) {
            return new Huiny(a.p * b.q + b.p * a.q, a.q * b.q);
        }

        public static Huiny divide(int p, Huiny q) {
            return new Huiny(q.q*p, q.p);
        }
    }
}
