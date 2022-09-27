import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Simple {
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
        int s = nextInt();
        int n = nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nextInt();
        }

        boolean[][] dp = new boolean[n + 1][s + 1];
        boolean[][] get = new boolean[n + 1][s + 1];
        List<Integer>[][] ans = new List[n + 1][s + 1];
        dp[0][0] = true;
        ans[0][0] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s; j++) {
                ans[i][j] = new ArrayList<>();
                if (arr[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                try {
                    if (dp[i][j] && dp[i-1][j-arr[i]]) {
                        get[i][j] = true;
                    }
                } catch (Exception e) {}
            }
        }

        List<Integer> kamni = new ArrayList<>();
        for (int i = s; i >= 0; i--) {
            if (dp[n][i]) {
                pw.print(i);
                while (i > 0) {
                    if (get[n][i]) {
                        kamni.add(n);
                        i -= arr[n];
                    }
                    n--;
                }
                pw.println(" " + kamni.size());
                Collections.reverse(kamni);
                for(int t: kamni) {
                    pw.printf("%d ", t);
                }
                return;
            }
        }


    }
}
