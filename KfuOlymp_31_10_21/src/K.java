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

        int n = nextInt();
        arr = new long[n+1];
        for (int i = 0; i < n; i++) {
            arr[i+1] = arr[i] + nextInt();
        }
        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
//        solve();
        pw.close();
    }
    static long[] arr;

    private static void solve() {
        int s = nextInt();
        int f = nextInt();
        int cou = 0;
        int i = s;
        while (i<f) {
            i = Math.min(f, (int) (i + Math.ceil((arr[i]-arr[s-1])/(i-s+1.0))));
            cou++;
        }
        pw.println(cou);
    }
}