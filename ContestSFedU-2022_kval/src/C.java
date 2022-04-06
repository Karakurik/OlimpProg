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
        int k = nextInt();
        int q = nextInt();
        int[] man = new int[n + 1];
        int[] wom = new int[n + 1];
        man[1] = 1;
        wom[1] = 1;
        for (int i = 2; i <= n; i++) {
            boolean m = false;
            boolean w = false;
            man[i] = -1;
            wom[i] = -1;
            if (i == k) {
                man[i] = 1;
                m = true;
            }
            if (i == q) {
                wom[i] = 1;
                w = true;
            }
            if (!m &&
                    (wom[i - 1] != 1 || i - k > 0 && wom[i - k] != 1)
            ) {
                man[i] = 1;
            }
            if (!w &&
                    (man[i - 1] != 1 || i - q > 0 && man[i - q] != 1)
            ) {
                wom[i] = 1;
            }
        }
        pw.println(man[n]==1?"King":"Queen");
    }
}
