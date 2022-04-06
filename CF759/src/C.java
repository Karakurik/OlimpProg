import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
        int n = nextInt();
        int k = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        int l = Math.abs(arr[0]);
        int r = Math.abs(arr[n - 1]);
        long ans = 0L;
        if (arr[n - 1] >= 0 && arr[0] <= 0) {
            if (l > r) {
                ans -= l;
            } else {
                ans -= r;
            }
        } else if (arr[n - 1] > 0 && arr[0] > 0) {
            ans -= r;
        } else if (arr[n - 1] < 0 && arr[0] < 0) {
            ans -= l;
        }

        int id = 0;
        while (id < n && arr[id] < 0) {
            ans += -2 * arr[id];
            id += k;
        }

        id = n - 1;
        while (id >= 0 && arr[id] > 0) {
            ans += 2 * arr[id];
            id -= k;
        }
        pw.println(ans);
    }
}