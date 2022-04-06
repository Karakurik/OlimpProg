import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G {
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

    static int n;
    static int k;
    static int[] arr;
    static int ans = 0;
    static int e = 1_000_000_007;

    private static void solve() {
        n = nextInt();
        k = nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        calc(0, 0, n + 1);

        pw.println(ans);
    }

    public static void calc(int cou, int i, int pred) {
        if (cou == k) {
            ans = (ans + 1) % e;
            return;
        }

        for (int j = i; j < n-k+cou+1; j++) {
            if (arr[j] >= pred) continue;

            calc(cou+1, j + 1, arr[j]);
        }
    }
}
