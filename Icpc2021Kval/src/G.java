import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G {
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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
//        pw = new PrintWriter(new FileWriter("output.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        int t = 1;
        t = nextInt();
        while (t-- > 0) {
            solve();
        }

//        solve();

        pw.close();
    }

    private static void solve() {
        long k = nextLong();
        long x = nextLong();
        long l = 1;
        long r = 2 * k - 1;
        long potAns = l;
        while (l <= r) {
            long m = (l + r) / 2;
            long cou = 0;
            long couM = 2 * k - m;
            if (m <= k) {
                couM = m;
                cou += m * (m + 1) / 2;
            } else {
                cou += k * (k + 1) / 2;
                cou += k * (k - 1) / 2;
                cou -= couM * (couM - 1) / 2;
            }
            if (cou - couM < x) {
                potAns = Math.max(potAns, m);
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        pw.println(potAns);
    }
}