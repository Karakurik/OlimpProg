import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
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
        char color = nextToken().charAt(0);
        String s = nextToken();
        s = s.concat(s);
        if (color == 'g') {
            pw.println(0);
            return;
        }
        int ans = 0;
        boolean flag = false;
        int cou = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == color && !flag) {
                flag = true;
            } else if (flag) {
                cou++;
            }
            if (s.charAt(i) == 'g') {
                ans = Math.max(ans, cou);
                cou = 0;
                flag = false;
            }
        }
        pw.println(ans);
    }
}
