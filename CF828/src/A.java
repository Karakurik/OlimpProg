import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
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
        HashSet<Integer>[] arr = new HashSet[51];
        for (int i = 0; i < 51; i++) {
            arr[i] = new HashSet<>();
        }
        for (int i = 0; i < n; i++) {
            arr[nextInt()].add(i);
        }
        String s = nextLine();
        for (HashSet set: arr) {
            Character c = null;
            for (Object i: set) {
                if (c == null) {
                    c = s.charAt((Integer) i);
                } else {
                    if (c != s.charAt((Integer) i)) {
                        pw.println("NO");
                        return;
                    }
                }
            }
        }
        pw.println("YES");
        return;
    }
}
