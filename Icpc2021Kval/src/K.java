import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class K {
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

        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
//        solve();
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        int l = 0;
        int r = 2 * 100000;
        int potAns = r;
        while (l <= r) {
            int m = (l + r) / 2;
            boolean flag = true;
            long akk = 0;
            for (int i = 0; i < n; i++) {
                long rub = Math.max(akk + arr[i] - m, 0);
                if (rub > m) {
                    flag = false;
                }
                akk = 2 * rub;
            }
            if (akk > 0) flag = false;
            if (flag) {
                potAns = Math.min(potAns, m);
                r = m-1;
            } else {
                l = m + 1;
            }
        }
        pw.println(potAns);
    }
}