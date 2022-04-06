import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class С {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken () {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static char nextChar() {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static int nexInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        solve();
        pw.close();
    }

    private static void solve() {
        List<String> list = Arrays.asList(nextLine().split(" "));
        int n = nexInt();
        if (n != list.size()) {
            pw.println(-1);
            return;
        }
        Integer k1 = null;
        Integer k2 = null;
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            if (s.length() != list.get(i).length()){
                pw.println(-1);
                return;
            }
            for (int j = 0; j < s.length(); j++) {
                char c1 = s.charAt(j);
                char c2 = list.get(i).charAt(j);
                if (k1 == null) {
                    k1 = (c1>c2)?c1-c2:c2-c1;
                    k1 = Math.min(k1, 26-k1);
                } else {
                    k2 = (c1>c2)?c1-c2:c2-c1;
                    k2 = Math.min(k2, 26-k2);
                    if (k1 != k2) {
                        pw.println(-1);
                        return;
                    }
                }
            }
        }
        pw.println(k1);
    }
}
