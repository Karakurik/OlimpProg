import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
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
    static int m;
    static int[][] arr;
    static boolean[] used;
    static List<Integer> list;

    private static void solve() {
        n = nextInt();
        m = nextInt();
        arr = new int[n+1][2];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr[i][0] = n;
            arr[i][1] = 1;
        }
        for (int i = 0; i < m; i++) {
            int t = nextInt();
            int l = nextInt();
            int r = nextInt();
            int u = nextInt();
            for (int j = l; j <= r; j++) {
                if (t == 1) {
                    arr[j][0] = Math.min(arr[j][0], u);
                } else {
                    arr[j][1] = Math.max(arr[j][1], u);
                }
            }
        }
        used = new boolean[n+1];
        if (check(1)) {
            for (int i = n - 1; i >= 0; i--) {
                pw.print(list.get(i) + " ");
            }
        } else {
            pw.println(-1);
        }
    }

    private static boolean check(int current) {
        if (current == n+1) {
            return true;
        }

        for (int i = arr[current][1]; i <= arr[current][0]; i++) {
            if (!used[i]) {
                used[i] = true;
                if (check(current + 1)) {
                    list.add(current);
                    return true;
                }

                used[i] = false;
            }
        }
        return false;
    }
}
