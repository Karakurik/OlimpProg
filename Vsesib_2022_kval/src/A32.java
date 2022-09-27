import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A32 {
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        Set<Integer>[][] arr = new HashSet[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < n; i++) {
            char[] s = nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                boolean flag = true;
                for (int k = j * m; k < j * m + m; k++) {
                    flag &= s[k] == '0';
                }
                if (flag) {
                    arr[i][0].add(j);
                }

                flag = true;
                for (int k = j; k < m * m; k += m) {
                    flag &= s[k] == '0';
                }
                if (flag) {
                    arr[i][1].add(j);
                }
            }
        }

        int ans = n + 1;
        int ansL = -2, ansR = -2;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            set.addAll(arr[i][0]);
            if (set.size() == m) {
                pw.printf("%d %d\n", i + 1, i + 1);
                return;
            }


            for (int r = i + 1; r < n; r++) {
                pw.printf("noans %d %d\n", i, r);
                if (ans <= r - i + 1) break;
                Set<Integer> newSet = new HashSet<>();

                for (int j = 0; j < m; j++) {
                    Set<Integer> tempSet = new HashSet<>();
                    for (int k = 0; k < m; k++) {
                        if (set.contains(j) && arr[r][1].contains(k)) {
                            tempSet.add(k);
                        }
                    }
                    if (tempSet.size() == m) {
                        newSet.add(j);
                    }
                }


                if (newSet.size() == m) {
                    if (ans > r - i + 1) {
                        ans = r - i + 1;
                        ansL = i;
                        ansR = r;
                    }
                }
                set = newSet;
            }
        }
        pw.printf("%d %d\n", ansL + 1, ansR + 1);
    }
}
