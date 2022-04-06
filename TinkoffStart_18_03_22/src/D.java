import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
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
        char start = 'a';
        int i, j;
        char[][] arr = new char[n][n];
        int itCou = n/2;
        if (n%2==1) itCou++;
        for (i = 0; i < itCou; i++) {
            start = 'a';
            for (j = i; j >= 0; j--) {
                arr[i][j] = start;
                start = incChar(start);
            }
            start = 'a';
            for (j = i; j < n/2; j++) {
                arr[i][j] = start;
                start = incChar(start);
            }
            if (n%2==1) arr[i][j] = start;
            start = 'a';
            for (j = n-i-1; j >= n/2 ; j--) {
                arr[i][j] = start;
                start = incChar(start);
            }
            start = 'a';
            for (j = n-i-1; j <n ; j++) {
                arr[i][j] = start;
                start = incChar(start);
            }
        }
        for (i = itCou; i < n; i++) {
            for (j = 0; j < n; j++) {
                arr[i][j] = arr[n-i-1][j];
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                pw.print(arr[i][j]);
            }
            pw.println();
        }
    }

    public static char incChar(char c) {
        if (c=='z') return 'a';
        return (char) (c+1);
    }
}
