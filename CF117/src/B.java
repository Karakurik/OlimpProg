import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class B {
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
        int a = nextInt();
        int b = nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(a);
        for (int i = n; i > 0; i--) {
            if (i != a && i != b) {
                list.add(i);
            }
        }
        list.add(b);
        if (list.subList(0, n / 2).stream().min(Comparator.comparingInt(o -> o)).get() == a
                && list.subList(n / 2, n).stream().max(Comparator.comparingInt(o -> o)).get() == b) {
            for (Integer i : list) {
                pw.print(i + " ");
            }
        } else {
            pw.print("-1");
        }
        pw.println();
        pw.flush();
    }
}