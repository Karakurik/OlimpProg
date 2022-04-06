import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class I2 {
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

    static int[] arr;
    static int[][] max;
    static int n;
    static int h;
    static int k;
    static int ans;
    static int curH;
    static int rivok;

    private static void solve() {
        n = nextInt();
        h = nextInt();
        k = nextInt();
        ans = 0;
        curH = 0;
        rivok = 0;
        arr = new int[n];
        max = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                max[i][j] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] <= h) {
                climb(i, false);
            } else if (arr[i] <= h + k) {
                climb(i, true);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                ans = Math.max(ans, max[i][j]);
            }
        }

        pw.println(ans);
    }

    private static int climb(int i, boolean b) {
        int maxH = arr[i];
        if (b) {
            if (max[i][1] == -1) {
                int l = i - 1;
                int r = i + 1;
                int maxId = i;
                while (l >= 0 /*&& arr[l] <= arr[i] + h*/) {
                    if (arr[l] <= arr[i] + h && arr[l] > arr[maxId]) maxId = l;
                    l--;
                }
                while (r < n /*&& arr[r] <= arr[i] + h*/) {
                    if (arr[r] <= arr[i] + h && arr[r] > arr[maxId]) maxId = r;
                    r++;
                }
                if (maxId != i) {
                    maxH = Math.max(maxH, climb(maxId, true));
                }
            }
            max[i][1] = maxH;
            return max[i][1];
        } else {
            if (max[i][0] == -1) {
                maxH = arr[i];
                int l = i - 1;
                int r = i + 1;
                int maxId = i;
                while (l >= 0 /*&& arr[l] <= arr[i] + h*/) {
                    if (arr[l] <= arr[i] + h && arr[l] > arr[maxId]) maxId = l;
                    l--;
                }
                while (r < n /*&& arr[r] <= arr[i] + h*/) {
                    if (arr[r] <= arr[i] + h && arr[r] > arr[maxId]) maxId = r;
                    r++;
                }
                if (maxId != i) {
                    maxH = Math.max(maxH, climb(maxId, false));
                }
                max[i][0] = maxH;
            }

            if (max[i][2] == -1) {
                maxH = arr[i];
                int l = i - 1;
                int r = i + 1;
                int maxId = i;

                while (l >= 0 /*&& arr[l] <= arr[i] + h + k*/) {
                    if (arr[l] <= arr[i] + h + k && arr[l] > arr[maxId]) maxId = l;
                    l--;
                }
                while (r < n /*&& arr[r] <= arr[i] + h + k*/) {
                    if (arr[r] <= arr[i] + h + k && arr[r] > arr[maxId]) maxId = r;
                    r++;
                }
                if (maxId != i) {
                    maxH = Math.max(maxH, climb(maxId, true));
                }
                max[i][2] = maxH;
            }
            return Math.max(max[i][0], max[i][2]);
        }
    }
}
