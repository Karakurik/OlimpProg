import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        int coum = 0;
        int coup = 0;
        int cou0 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                coum++;
            }
            if (arr[i] == 0) {
                cou0++;
            }
            if (arr[i] > 0) {
                coup++;
            }
        }
        if (coum % 2 == 0) {
            if (cou0 > 0) {
                pw.println(0);
            } else {
                if (coup > 0) {
                    for (int i = 0; i < n; i++) {
                        if (arr[i] > 0) {
                            pw.println(arr[i]);
                            break;
                        }
                    }
                } else {
                    pw.println(arr[0]);
                }
            }
        } else {
            if (cou0 == 0 && coup == 0) {
                pw.println(arr[n-1]);
            } else {
                for (int i = 0; i < n; i++) {
                    if (arr[i] >= 0) {
                        pw.println(arr[i - 1]);
                        break;
                    }
                }
            }
        }
    }
}
