import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class L {
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

    private static void solve() {
        int n = nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nextInt();
        }
        int l = 0;
        int r = 200000;
        int k = 0;
        int potentialAns = -1;
        while (l <= r) {
            int x = (l + r) / 2;
            k = 0;
            boolean flag = true;
            for (int i = 1; i <= n; i++) {
                int k1 = k;
                k = 0;
                int m = arr[i] + k1;
                int x2 = 0;
                if (m-x>0) {
                    x2 = m-x;
                }
                int x1 = x-x2;
                k = 2*x2;
                if (m-k > x1 || x1<0 || i==n && x2>0) {
                    flag = false;
                    break;
                }


//                int x1 = x;
//                while (arr[i] + k1 - k > x1) {
//                    k += 2;
//                    x1--;
//                }
//                if (x1 < 0 || i == n && k > 0) {
//                    flag = false;
//                    break;
//                }
            }
            if (flag) {
                if (potentialAns == -1 || potentialAns > x) {
                    potentialAns = x;
                }
                r = x - 1;
            } else {
                l = x + 1;
            }
        }
        pw.println(potentialAns);
    }
}