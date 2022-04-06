import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I {
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
        long n = nextLong();
        long h = nextLong();
        long k = nextLong();
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        Arrays.sort(arr);
        int id = 0;
        boolean used = false;
        long high = 0;
        if (arr[id] > h + k) {
            pw.println(0);
            return;
        } else {
            if (arr[id] > h) {
                used = true;
                high = h + k;
            }
        }
        while (id < n - 1) {
            if (arr[id + 1] <= arr[id] + h || arr[id + 1] <= high) {
                id++;
                continue;
            } else if (!used && arr[id + 1] <= arr[id] + h + k) {
                used = true;
                high = arr[id] + h + k;
                continue;
            }
            pw.println(arr[id]);
            return;
        }
        pw.println(arr[id]);
    }
}
