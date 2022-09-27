import java.io.*;
import java.util.StringTokenizer;

public class M {
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

        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
//        solve();
        pw.close();
    }

    private static void solve() {
        int n1 = nextInt();
        int n2 = nextInt();
        int n3 = nextInt();
        String s1 = nextLine().toLowerCase();
        String s2 = nextLine().toLowerCase();
        String s3 = nextLine().toLowerCase();
        pw.println(check(n1, s1, 5) && check(n2, s2, 7) && check(n3, s3, 5) ? "YES":"NO");
    }

    private static boolean check(int n1, String s1, int i) {
        String s = "aeiou";
        int cou = 0, couY = 0;
        for (char c: s1.toCharArray()) {
            if (c == 'y') couY++;
            if (s.indexOf(c) >=0) cou++;
        }
        return cou <= i && cou + couY >= i;
    }
}