import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T2 {
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
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int[] arr : new int[][]{a, b, c}) {
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            Arrays.sort(arr);
        }

        int k = 0;
        long[] couB = new long[n+1];
        for (int j = 0; j < n; j++) {
            while (k != n && c[k] <= b[j]) k++;
            couB[j+1] = couB[j] + (n-k);
        }

        int j = 0;
        long cou = 0L;
        for (int i = 0; i < n; i++) {
            while (j != n && b[j] <= a[i]) j++;
            cou += couB[n] - couB[j];
        }
        pw.println(cou);
    }
}

/*
2
1 4
3 5
3 6
*/

/*
3
1 1 1
9 9 9
10 13 42
*/

/*
3
1 2 3
5 4 3
4 6 5
*/
