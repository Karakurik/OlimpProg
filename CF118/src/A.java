import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
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
        String x1 = nextLine();
        String x2 = nextLine();
        int p1 = Integer.parseInt(x1.substring(x1.indexOf(' ')+1));
        int p2 = Integer.parseInt(x2.substring(x2.indexOf(' ')+1));
        x1  =x1.substring(0, x1.indexOf(' '));
        x2  =x2.substring(0, x2.indexOf(' '));

        int i = comparator(x1, p1, x2, p2);
        if (i>0) {
            pw.println(">");
            pw.flush();
            return;
        } else if (i<0) {
            pw.println("<");
            pw.flush();
            return;
        } else {
            pw.println("=");
            pw.flush();
        }
    }

    private static int comparator(String x1, int p1, String x2, int p2) {
        if (x1.length() + p1 > x2.length() + p2) return 1;
        if (x1.length() + p1 < x2.length() + p2) return -1;
        if (x1.length() == x2.length()) {
            for (int i = 0; i < x1.length(); i++) {
                if (x1.charAt(i) > x2.charAt(i)) return 1;
                if (x1.charAt(i) < x2.charAt(i)) return -1;
            }
            return 0;
        }
        if (x1.length() > x2.length()) {
            for (int i = 0; i < x2.length(); i++) {
                if (x1.charAt(i) > x2.charAt(i)) return 1;
                if (x1.charAt(i) < x2.charAt(i)) return -1;
            }
            for (int i = x2.length(); i < x1.length(); i++) {
                if (x1.charAt(i) > '0') return 1;
            }
            return 0;
        } else {
            if (x2.length() > x1.length()) {
                for (int i = 0; i < x1.length(); i++) {
                    if (x1.charAt(i) > x2.charAt(i)) return 1;
                    if (x1.charAt(i) < x2.charAt(i)) return -1;
                }
                for (int i = x1.length(); i < x2.length(); i++) {
                    if (x2.charAt(i) > '0') return -1;
                }
                return 0;
            }
        }
        return 0;
    }

}