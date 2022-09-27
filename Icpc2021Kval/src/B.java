import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
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
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();
        int[] arr = new int[n];
        arr[0] = a;
        arr[n - 1] = b;
        int cur = n;
        for (int i = 1; i < n / 2; i++) {
            while (cur == a || cur == b) {
                cur--;
            }
            if (cur < a || cur < 1) {
                pw.println(-1);
                return;
            }
            arr[i] = cur;
            cur--;
        }
        cur = 1;
        for (int i = n / 2; i < n - 1; i++) {
            while (cur == a || cur == b) {
                cur++;
            }
            if (cur > b || cur > n) {
                pw.println(-1);
                return;
            }
            arr[i] = cur;
            cur++;
        }
        for (int x : arr) {
            pw.printf("%d ", x);
        }
        pw.println();
    }
}