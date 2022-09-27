import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class H {
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
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        List<Long> list = new ArrayList<>();
        list.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            }
        }
        n = list.size();
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = list.get(i);
        }
        list.clear();
        long mi = arr[0];
        long ma = -1;
        long ans = 0;
        long lastMi = mi;
        long lastMa = ma;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                lastMa = arr[i];
            }
            if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                mi = arr[i];
                if (lastMa != -1L) {
                    ans = Math.max(ans, Math.min(lastMa - lastMi, lastMa - mi));
                }
                lastMi = mi;
            }
        }
        if (arr[n - 1] < arr[n - 2]) {
            mi = arr[n - 1];
            if (lastMa != -1) {
                ans = Math.max(ans, Math.min(lastMa - lastMi, lastMa - mi));
            }
        }
        pw.println(ans);
    }
}
