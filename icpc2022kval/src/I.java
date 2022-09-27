import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringTokenizer st;

    static String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
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

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) {
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int k = nextInt();
        int f = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        int l = 0;
        int r = f;
        int potAns = r;
        while (l <= r) {
            int m = (r + l) / 2;
            boolean flag = true;
            int len = 0;
            int last = -1;
            int cou = k;
            for (int i = 0; i < n; i++) {
                if (arr[i] - m > len) {
                    if (last == i - 1) {
                        flag = false;
                        break;
                    } else {
                        len = arr[i-1] + m;
                        cou--;
                        last = i-1;
                        if (cou < 0) {
                            flag = false;
                            break;
                        }
                        if (len >= f) {
                            break;
                        }
                        i--;
                    }
                } else if (arr[i] + m >= f) {
                    len = arr[i] + m;
                    cou--;
                    if (cou < 0) {
                        flag = false;
                        break;
                    }
                    if (len >= f) {
                        break;
                    }
                }
            }
            if (flag && len >= f) {
                potAns = Math.min(potAns, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        pw.println(potAns);
    }
}
