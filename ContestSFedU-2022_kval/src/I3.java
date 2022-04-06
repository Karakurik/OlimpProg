import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class I3 {
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

    static int id;
    static int n;
    static long h;
    static long k;
    static long[] arr;

    static long max = 0;
    private static void solve() {
        n = nextInt();
        h = nextLong();
        k = nextLong();
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }

        for (id = 0; id < n; id++) {
            int t = climb();
            if (t != -1) id = t;
        }

        for (id = n - 1; id >= 0; id--) {
            int t = climbL();
            if (t != -1) id = t;
        }

        pw.println(max);
    }

    private static int climb() {
        boolean used = false;
        if (arr[id] > h+k) {
            return -1;
        }
        int temp = -1;
        while (id < n - 1) {
            max = Math.max(max, arr[id]);
            if (arr[id + 1] <= arr[id] + h) {
                id++;
                continue;
            }
            return temp;
        }
        max = Math.max(max, arr[id]);
        return temp;
    }

    private static int climbL() {
        boolean used = false;
        if (arr[id] > h+k) {
            return -1;
        }
        int temp = -1;
        while (id > 0) {
            max = Math.max(max, arr[id]);
            if (arr[id - 1] <= arr[id] + h) {
                id--;
                continue;
            }
            max = Math.max(max, arr[id]);
            return temp;
        }
        max = Math.max(max, arr[id]);
        return temp;
    }
}
