import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out, true);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
//            for (int n = 0; n < 10; n++) {
//                for (int k = 0; k < 10; k++) {
//                    pw.println((n+1) + " " + (k+1));
                    if (solve(/*n+1, k+1*/)) {
                        pw.println("Yes");
                        for (var inner : arr) {
                            for (var el : inner) {
                                pw.print(el + " ");
                            }
                            pw.println();
                        }
                    } else {
                        pw.println("No");
                    }
//                    pw.println();
//                }
//            }

        }

        pw.close();
    }

    static int[][] arr;

    private static boolean solve(/*int n, int k*/) {
        int n = nextInt();
        int k = nextInt();
        if (n * n % k != 0) return false;
        if (n != 1 && k == 1) return false;

        arr = new int[n][n];

        int[] count = new int[k+1];
        Arrays.fill(count, n*n/k);

        if (n * n / k >= n) {
            int color = 1;
            for (int i = 0; i < n; i++) {
                if (color > k) color = 1;
                while (count[color]==0) {
                    color++;
                    if (color > k) color = 1;
                }
                for (int j = 0; j < n; j++) {
                    if (color > k) color = 1;
                    while (count[color]==0) {
                        color++;
                        if (color > k) color = 1;
                    }
                    arr[(i + j) % n][j] = color;
                    count[color]--;
                }
                color++;

            }
            return true;
        } else {
            int color = 1;
            int cou = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[(i + j) % n][j] = color;
                    cou++;
                    if (cou == n * n / k) {
                        cou = 0;
                        color++;
                    }
                }
            }
            return true;
        }
    }
}
