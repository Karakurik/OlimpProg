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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int[] arr = new int[n + 1];
        int[] cou2 = new int[n + 1];
        int cou = 0;
        int ans = 0;
        int ansCou2 = 0;
        int ansId = 0;
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            if (t!=0) cou2[i+1] = cou2[i];
            if (Math.abs(t) == 2) cou2[i + 1] = cou2[i] + 1;
            if (t < -1) t = -1;
            if (t > 1) t = 1;
            if (arr[i] == 0) {
                arr[i + 1] = t;
            } else {
                arr[i + 1] = arr[i] * t;
            }
        }
        int predM = 0;
        for (int i = 0; i <= n; i++) {
            if (arr[i] == 0) {
                cou = 0;
                predM = 0;
            } else {
                cou++;
                if (arr[i] > 0) {
                    if (ansCou2 <= cou2[i] && ans < cou) {
                        ans = cou;
                        ansCou2 = cou2[i];
                        ansId = i;
                    }
                } else {
                    if (predM == 0) {
                        predM = i;
                    } else {
                        if (ansCou2 < cou2[i]-cou2[predM]||ansCou2 == cou2[i]-cou2[predM] && ans < i-predM) {
                            ans = i-predM;
                            ansCou2 = cou2[i]-cou2[predM];
                            ansId = i;
                        }
                    }
                }
            }
        }
        pw.println((ansId - ans) + " " + (n - ansId));
    }
}
