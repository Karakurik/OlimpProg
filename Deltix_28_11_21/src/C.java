import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int e = nextInt();
        long ans = 0L;
        int[][] arr = new int[e][3];
        for (int i = 0; i < e; i++) {
            arr[i][0] = -1;
        }

        for (int i = 0; i < n; i++) {
            int t = nextInt();
            if (i < e) {
                if (t == 1) {
                    arr[i][2]++;
                }
                if (t > 1) {
                    if (isPrime(t)) {
                        arr[i][0] = t;
                    }
                }
                continue;
            }

            int id = i % e;
            if (t == 1) {
                if (arr[id][0] != -1) {
                    ans++;
                    ans += arr[id][1];
                }
                arr[id][2]++;
            }
            if (t > 1) {
                if (isPrime(t)) {
                    ans += arr[id][2];
                    arr[id][1] = arr[id][2];
                    arr[id][2] = 0;
                    arr[id][0] = t;
                } else {
                    arr[id][1] = 0;
                    arr[id][2] = 0;
                    arr[id][0] = -1;
                }
            }
        }
        pw.println(ans);
        pw.flush();
    }

    private static boolean isPrime(int t) {
        if (t == 2) return true;
        for (int i = 2; i < Math.sqrt(t) + 1; i++) {
            if (t % i == 0) return false;
        }
        return true;
    }
}