import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C2 {
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
        int n = nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        Long l = 2L;
        Long r = 1_000_000_000_000_000_000L;
        Long m = 0L;
        while (l<=r) {
//            if
            m = (l+r)/2;
            int i1 = 0; int i2 = 0;
            for (int i = 0; i < n; i+=2) {
                if (arr[i]%m==0) {
                    if (i1==0) {
                        i1 = 1;
                    }
                    if (i1 == -1) continue;
                } else {
                    if (i1==0) {
                        i1 = -1;
                    }
                    if (i1==1) continue;
                }
                if (i+1<n) {
                    if (arr[i+1]%m==0) {
                        if (i2==0) i2 = 1;
                        if (i2==-1) continue;
                    } else {
                        if (i2==0) i2 = -1;
                        if (i2==1) continue;
                    }
                }

            }
        }
    }


}