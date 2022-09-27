import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class I {
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
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            left.add(i);
        }
        for (int i = 3; i <= n; i++) {
            right.add(i);
        }
        for (int i = n + 1; i <= 2 * n; i++) {
            if (left.size() < 2) {
                left.add(i);
            } else {
                right.add(i);
            }

            int leftMinIndex = 0;
            int rightMinIndex = 0;

            for (int j = 1; j < left.size(); j++) {
                pw.printf("? %d %d\n", left.get(leftMinIndex), left.get(j));
                if (nextLine().equals(">")) leftMinIndex = j;
            }

            for (int j = 1; j < right.size(); j++) {
                pw.printf("? %d %d\n", right.get(rightMinIndex), right.get(j));
                if (nextLine().equals(">")) rightMinIndex = j;
            }

            pw.printf("? %d %d\n", left.get(leftMinIndex), right.get(rightMinIndex));
            if (nextLine().equals(">")) {
                right.remove(rightMinIndex);
            } else {
                left.remove(leftMinIndex);
            }
        }
        pw.println("!");
    }
}
