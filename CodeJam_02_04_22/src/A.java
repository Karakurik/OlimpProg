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
        for (int i = 0; i < t; i++) {
            pw.println("Case #" + (i+1) + ":");
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        StringBuilder sb1 = new StringBuilder("..+");
        StringBuilder sb2 = new StringBuilder("..|");
        for (int i = 0; i < m-1; i++) {
            sb1.append("-+");
            sb2.append(".|");
        }
        StringBuilder sb3 = new StringBuilder(sb1);
        sb3 = sb3.replace(0, 2, "+-");
        StringBuilder sb4 = new StringBuilder(sb2);
        sb4 = sb4.replace(0, 2, "|.");
        pw.println(sb1.toString());
        pw.println(sb2.toString());
        pw.println(sb3.toString());
        for (int i = 0; i < n-1; i++) {
            pw.println(sb4.toString());
            pw.println(sb3.toString());
        }
    }
}
