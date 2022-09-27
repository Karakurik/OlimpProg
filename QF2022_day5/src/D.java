import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
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
        int n = nextInt();
        String[] arr = nextLine().split(" ");
        int ans = 0;
        for (String s : arr) {
            ans += count(s);
        }
        pw.println(ans);
    }

    static String help = "aeiouy";

    private static int count(String s) {
        int cou = cou1(s);
        cou = Math.min(cou, cou2(s));
        cou = Math.min(cou, cou3(s));
        return cou;
    }

    private static int cou2(String s) {
        int cou = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (help.indexOf(s.charAt(i)) < 0) cou++;
        }
        for (int i = 1; i < s.length(); i += 2) {
            if (help.indexOf(s.charAt(i)) >= 0) cou++;
        }
        return cou;
    }

    private static int cou3(String s) {
        int cou = 0;
        for (int i = 1; i < s.length(); i += 2) {
            if (help.indexOf(s.charAt(i)) < 0) cou++;
        }
        for (int i = 0; i < s.length(); i += 2) {
            if (help.indexOf(s.charAt(i)) >= 0) cou++;
        }
        return cou;
    }

    private static int cou1(String s) {
        int cou = 0;
        for (char c: s.toCharArray()) {
            if (help.indexOf(c) <0) cou++;
        }
        return cou;
    }
}
