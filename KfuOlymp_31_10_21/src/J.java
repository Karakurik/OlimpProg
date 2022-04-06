import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class J {
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
        br = new BufferedReader(new InputStreamReader(System.in));
//        pw = new PrintWriter(new FileWriter("output.txt"));
        pw = new PrintWriter(System.out);
//        int t = nextInt();
//        while (t-- > 0) {
//            solve();
//        }
        solve();
        pw.close();
    }

    static int b = 0;
    static int l = 0;
    static int t = 0;
    static int r = 0;
    static int e = 1_000_000_007;

    private static void solve() {
        int n = nextInt();
        int cou = 1;

        char[] chars = nextLine().toCharArray();

        for (int i = 0; i < n; i++) {
            switch (chars[i]) {
                case 'B':
                    t = (t+b)%e;
                    b = cou;
                    l = app(l);
                    r = app(r);
                    break;
                case 'L':
                    r = (r+l)%e;
                    l = cou;
                    b = app(b);
                    t = app(t);
                    break;
                case 'T':
                    b = (t+b)%e;
                    t = cou;
                    l = app(l);
                    r = app(r);
                    break;
                case 'R':
                    l = (r+l)%e;
                    r = cou;
                    b = app(b);
                    t = app(t);
                    break;
            }
            cou = app(cou);
        }
        pw.println(b + " " + l + " " + t + " " + r);
    }

    private static int app(int b) {
        return (b * 2) % e;
    }
}