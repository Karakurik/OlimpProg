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
        int k = nextInt();
        if (n==4 && k==3) {
            pw.println(-1);
            return;
        }
        if (k==0) {
            for (int i = n-1; i >=n/2 ; i--) {
                pw.println(i + " " + (n-1-i));
            }
            return;
        }
        if (n-1 != k) {
            pw.println(n-1 + " " + k);
            pw.println(0 + " " + (n-1 - k));
            for (int i = n-2; i >=n/2; i--) {
                if (i!=k&&i!=n-1-k) {
                    pw.println(i + " " + (n-1-i));
                }
            }
        } else {
            pw.println(n-1 + " " + (n-2));
            pw.println(0 + " " + 1);
            pw.println(n-3+" "+3);
            pw.println(n-4+" "+2);
            for (int i = n-5; i >=n/2&&i>5 ; i--) {
                pw.println(i + " " + (n-1-i));
            }
        }
    }
}
