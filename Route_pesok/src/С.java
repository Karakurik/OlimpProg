import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class С {
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
        int[] arr = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                int cand = -1;
                for (int j = i + 1; j < n; j++) {
                    if (!used[j]) {
                        if (cand == -1 || Math.abs(arr[j] - arr[i]) < Math.abs(arr[cand] - arr[i])) {
                            cand = j;
                        }
                    }
                }
                used[cand] = true;
                pw.println((i + 1) + " " + (cand + 1));
            }
        }
        pw.println();
    }
}
