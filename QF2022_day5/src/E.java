import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E {
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
        long n = nextLong();
        int ans = 0;
        while (n > 0) {
            int del = 1;
            StringBuilder nString = new StringBuilder(String.valueOf(n));
            for (int i = nString.length() - 1; i >= 0; i--) {
                if (nString.length() > 1 && nString.charAt(0) == '1' && nString.charAt(1) != '0') {
                    pw.println(ans);
                    return;
                }
                if (i == 0) del = 1;
                if (nString.charAt(i) == '0') {
                    nString.setCharAt(i, String.valueOf(10 - del).charAt(0));
                    del = 2;
                } else {
                    nString.setCharAt(i, String.valueOf(Character.getNumericValue(nString.charAt(i)) - del).charAt(0));
                    del = 1;
                }
            }
            n = Long.parseLong(nString.toString());
            ans++;
        }
        pw.println(ans);
    }
}
