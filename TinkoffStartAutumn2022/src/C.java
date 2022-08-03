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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        int mi = -1, ma = -1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (mi == -1 || arr[i] < arr[mi]) mi = i;
            } else {
                if (ma == -1 || arr[i] > arr[ma]) ma = i;
            }
        }
        if (mi != -1 && ma != -1 && arr[ma] - arr[mi] >= 0) {
            int c = arr[mi];
            arr[mi] = arr[ma];
            arr[ma] = c;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans += arr[i];
            } else {
                ans -= arr[i];
            }
        }
        pw.println(ans);
    }
}

/* Test1
2
1 2
*/

/* Answer1
1
*/

/* Test2
3
2 2 2
*/

/* Answer2
2
*/
