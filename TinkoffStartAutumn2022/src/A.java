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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        Point p1 = new Point(nextInt(), nextInt());
        Point p2 = new Point(nextInt(), nextInt());
        Point p3 = new Point(nextInt(), nextInt());
        Point p4 = new Point(nextInt(), nextInt());
        Point pd = new Point(Math.min(p1.x, p3.x), Math.min(p1.y, p3.y));
        Point pu = new Point(Math.max(p2.x, p4.x), Math.max(p2.y, p4.y));
        pw.println((int) Math.pow(Math.max(pu.x - pd.x, pu.y - pd.y), 2));
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/* Test1
6 6 8 8
1 8 4 9
*/

/* Answer1
49
*/
