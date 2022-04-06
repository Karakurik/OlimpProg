import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
        int[] arrA = new int[n];
        int[] arrB = new int[n];
        for (int i = 0; i < n; i++) {
            arrA[i] = nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = nextInt();
        }
        int sumF = Math.abs(arrA[0]-arrB[0]);
        int sumL = Math.abs(arrA[n-1]-arrB[n-1]);
        int sumF1 = sumF;
        int sumF2 = sumF;
        int sumL1 = sumL;
        int sumL2 = sumL;
        for (int i = 1; i < n-1; i++) {
            sumF1 = Math.min(sumF1, Math.abs(arrB[i]-arrA[0]));
            sumF2 = Math.min(sumF2, Math.abs(arrA[i]-arrB[0]));
            sumL1 = Math.min(sumL1, Math.abs(arrB[i]-arrA[n-1]));
            sumL2 = Math.min(sumL2, Math.abs(arrA[i]-arrB[n-1]));
        }


        pw.println(Math.min(Math.min(sumF, sumF1+sumF2)+Math.min(sumL, sumL1+sumL2), Math.abs(arrA[0]-arrB[n-1])+Math.abs(arrA[n-1]-arrB[0])));
    }
}
