import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = nextInt();
        }
        if (n == 1) {
            pw.println(1);
            return;
        }
        List<Integer> mas2 = new ArrayList<>();
        mas2.add(mas[0]);
        mas2.add(mas[1]);
        for (int i = 2; i < mas.length; i++) {
            if (mas[i - 1] == mas[i] && mas[i - 2] == mas[i]) {
                continue;
            }
            mas2.add(mas[i]);
        }

        mas = new int[mas2.size()];
        for (int i = 0; i < mas2.size(); i++) {
            mas[i] = mas2.get(i);
        }

        int flag = 0;
        int l = 0;
        int r = 0;
        int maxAns = 1;
        n = mas.length;
        while (r < n - 1) {
            boolean f = true;
            boolean first = true;
            boolean f2 = false;
            while (r < n-1) {
                if (mas[r] == mas[r+1]) {
                    f = true;
                    f2 = true;
                    r++;
                } else if (mas[r] + 1 == mas[r+1]) {
                    r++;
                } else if (mas[r] + 2 == mas[r+1]) {
                    if (!f) {
                        break;
                    }
                    if (!f2) {
                        first = false;
                    }
                    f = false;
                    f2 = false;
                    r++;
                    flag = r;
                } else {
                    flag = r + 1;
                    break;
                }
            }
            int mans = mas[r] - mas[l];
            if (first) {
                mans++;
            }
            if (f2) {
                mans++;
            }
            maxAns = Math.max(maxAns, mans);
            l = flag;
            r = Math.max(r, l);
        }
        pw.println(maxAns);
    }
}
