import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        pw = new PrintWriter(System.out);
        int t = 1;

        n = nextInt();
        m = nextInt();
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
//        n = 5;
//        m = 4;
//        for (int i = 0; i < 100; i++) {
//            solve(i);
//        }
        pw.close();
    }

    static int n;
    static int m;

    private static void solve() {
        int t = nextInt() + 1;
        if (t >= n * m + n) {
            pw.printf("%d %d\n", 1, m - 1);
            return;
        }
        int ansN = 0, ansM = 0;
        if (t <= (n / 2 + 1) * m + n / 2) {
            int div = t / (m + 1);
            int mod = t % (m + 1);
            ansN = -1;
            ansM = 0;
            if (div % 2 == 0) {
                ansN += 2 * div;
                if (mod > 0) {
                    mod--;
                    ansN++;
                }
                if (mod > 0) {
                    ansM += mod;
                }
            } else {
                ansN += 2 * div;
                ansM = m - 1;
                if (mod > 0) {
                    mod--;
                    ansN++;
                }
                if (mod > 0) {
                    ansM -= mod;
                }
            }
        } else {
            t -= (n / 2 + 1) * m + n / 2;
            if (n % 4 == 1) {
                if (t == 0 || t == 1) {
                    pw.printf("%d %d\n", n - 1, m - 1);
                    return;
                }
                if (t == 2) {
                    pw.printf("%d %d\n", n - 2, m - 1);
                    return;
                }
                t -= 2;
                ansN = n - 1;
                ansM = m - 1;
                int div = t / (m + 1);
                int mod = t % (m + 1);
                if (div % 2 == 0) {
                    ansN -= 2 * div;
                    if (mod > 0) {
                        mod--;
                        ansN--;
                    }
                    if (mod > 0) {
                        ansM -= mod;
                    }
                } else {
                    ansN -= 2 * div;
                    ansM = 0;
                    if (mod > 0) {
                        mod--;
                        ansN--;
                    }

                    if (mod > 0) {
                        ansM += mod;
                    }
                }
            } else {
                ansN = n - 1;
                ansM = 0;
                if (t == 0 || t == 1) {
                    pw.printf("%d %d\n", n - 1, 0);
                    return;
                }
                if (t == 2) {
                    pw.printf("%d %d\n", n - 2, 0);
                    return;
                }
                t -= 2;
                int div = t / (m + 1);
                int mod = t % (m + 1);
                if (div % 2 != 0) {
                    ansN -= 2 * div;
                    ansM = m - 1;
                    if (mod > 0) {
                        mod--;
                        ansN--;
                    }

                    if (mod > 0) {
                        ansM -= mod;
                    }
                } else {
                    ansN -= 2 * div;
                    ansM = 0;
                    if (mod > 0) {
                        mod--;
                        ansN--;
                    }

                    if (mod > 0) {
                        ansM += mod;
                    }
                }
            }

        }
        pw.printf("%d %d\n", ansN, ansM);
    }
}
