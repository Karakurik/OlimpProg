import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class T7 {
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
        long x = nextLong();
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }

        int t = n - 1;
        while (x < arr[t]) t--;
        long cou1 = Long.MAX_VALUE;
        long cou2 = Long.MAX_VALUE;
        if (t >= 0) {
            cou1 = count(x, t);
        }
        if (t < n - 1) {
            cou2 = 1 + count(arr[t + 1] - x, t);
        }
        pw.println(Math.min(cou1, cou2));
    }

    static long[] arr;

    private static long count(long x, int t) {
        if (x == 0) return 0;
        while (x < arr[t]) t--;

        long cou1 = Long.MAX_VALUE;
        long cou2 = Long.MAX_VALUE;
        if (x % arr[t] == 0) {
            return x/arr[t];
        }
        cou1 = x / arr[t] + count(x % arr[t], t - 1);
        cou2 = x / arr[t] + 1 + count(arr[t] - x % arr[t], t - 1);
        return Math.min(cou1, cou2);
    }
}

/*
5 36
1 3 9 45 90
*/

/*
6 42
1 5 10 20 80 400
*/

/*
4 141795520669162
1 62278 4480217042 206094464149042
*/
