import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chill800 {
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static int[] arr;

    private static void solve() {
        long hc = nextLong();
        long dc = nextLong();
        long hm = nextLong();
        long dm = nextLong();
        long k = nextLong();
        long w = nextLong();
        long a = nextLong();
        long dieC = countDie(hc, dm);
        dc += k * w;
        long dieM = countDie(hm, dc);
        if (dieC >= dieM) {
            pw.println("YES");
            return;
        }
        for (long i = 0; i < k; i++) {
            dc -= w;
            hc += a;
            dieC = countDie(hc, dm);
            dieM = countDie(hm, dc);
            if (dieC >= dieM) {
                pw.println("YES");
                return;
            }
        }
        pw.println("NO");
    }

    private static long countDie(long hc, long dm) {
        if (hc%dm==0) return hc/dm;
        return hc/dm + 1;
    }
}
