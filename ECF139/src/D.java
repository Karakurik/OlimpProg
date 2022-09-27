import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D {
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
        sieveOfEratosthenes(10000000);
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    static List<Integer> prime = new ArrayList<>();
    static boolean[] used;

    public static void sieveOfEratosthenes(int n) {
        used = new boolean[n + 1];

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (!used[i]) {
                prime.add(i);
                for (int j = 2*i; j <= n; j += i) {
                    used[j] = true;
                }
            }
        }
    }

    private static void solve() {
        int a = nextInt();
        int b = nextInt();
        if (a + 1 == b) {
            pw.println(-1);
            return;
        }

        if (a == 1 && b == 1) {
            pw.println(1);
            return;
        }

        int g = gcd(a, b);
        if (g != 1) {
            pw.println(0);
            return;
        }

        if (a % 2 == 1 && b % 2 == 1) {
            pw.println(1);
            return;
        }

        g = b - a;
        int ans = g - a % g;
        Set<Integer> list = new HashSet<>();

        if (!used[g]) {
            list.add(g);
        } else {
            for (int i : prime) {
                if (g % i == 0) {
                    list.add(i);
                    list.add(g / i);
                    if (list.size() > 10) break;
                }
            }
            for (int s : list) {
                ans = Math.min(ans, s - a % s);
            }
        }

        pw.println(ans);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
