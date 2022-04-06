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
        long k = nextLong();
        long x = nextLong();
        long potentialAns = -1;
        long r = 2*k-1;
        long l = 1;
        while (l <= r) {
            boolean flag = true;
            long t = (l+r)/2;
//            long t = 1750000000;
            long s = 0L;
            if (t <= k) {
                s = t*(t+1) / 2;
            } else {
                s = k*k;
                long minusT = 2*k-t;
                long sminus = ((minusT)*(minusT-1)) / 2;
                s -= sminus;
            }
            if (s < x) {
                l = t+1;
                if (potentialAns==-1 || potentialAns<t) {
                    potentialAns = t;
                }
            } else {
                r = t-1;
                flag = false;
            }
        }

        if (potentialAns==-1) {
            potentialAns = 0;
        }
        pw.println(Math.min(2*k-1, potentialAns+1));
        pw.flush();
    }
}