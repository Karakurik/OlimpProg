import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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

    static int[] arr;
    static int[] down;
    static int[] ans;

    private static void solve() {
        int n = nextInt();
        arr = new int[n + 1];
        down = new int[n + 1];
        ans = new int[n + 1];
        Arrays.fill(ans, -2);
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            down[i + 1] = nextInt();
        }
        pw.println(count(n));
    }

    private static int count(int n) {
        n += down[n];
        if (ans[n] != -2) return ans[n];
        if (n - arr[n] <= 0) return 1;
//        if (arr[n] == 0) return -1;
        int min = -1;
        for (int i = 1; i <= arr[n]; i++) {
            if (n - i + down[n - i] >= n) continue;
            int c = count(n - i);
            if (c != -1) {
                if (min == -1 || c < min) {
                    min = c;
                }
            }
        }
        if (min==-1) {
            ans[n] = min;
        } else {
            ans[n] = min+1;
        }
        return ans[n];
    }
}