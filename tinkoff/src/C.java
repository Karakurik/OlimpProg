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
        if (n > 27) {
            pw.println(0);
            return;
        }
        long ans = 0L;
        for (int i1 = 0; i1 < 10; i1++) {
            for (int i2 = 0; i2 < 10; i2++) {
                for (int i3 = 0; i3 < 10; i3++) {
                    if (i1 + i2 + i3 != n) continue;
                    for (int i4 = 0; i4 < 10; i4++) {
                        for (int i5 = 0; i5 < 10; i5++) {
                            for (int i6 = 0; i6 < 10; i6++) {
                                if (i4 + i5 + i6 != n) continue;
                                for (int i7 = 0; i7 < 10; i7++) {
                                    if (i1+i4+i7!=n) continue;
                                    for (int i8 = 0; i8 < 10; i8++) {
                                        if (i2+i5+i8!=n) continue;
                                        for (int i9 = 0; i9 < 10; i9++) {
                                            if (i7+i8+i9==n &&
                                                i3+i6+i9==n) {
                                                ans++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        pw.println(ans);
    }
}