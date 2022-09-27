import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        List<Pair> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            int cou = 0;
            while (t % 2 == 0 && t > 0) {
                cou++;
                t /= 2;
            }
            int cou2 = 0;
            t = i + 1;
            while (t % 2 == 0 && t > 0) {
                cou2++;
                t /= 2;
            }
            count += cou;
            list.add(new Pair(cou, cou2));
        }
        list.sort((o1, o2) -> o2.second - o1.second);
        int ans = 0;
        for (Pair p : list) {
            if (count >= n) {
                pw.println(ans);
                return;
            }
            count += p.second;
            ans++;
        }
        pw.println(count >= n ? ans : -1);
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
