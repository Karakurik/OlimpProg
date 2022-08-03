import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {
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
        Lift[] lifts = new Lift[n];
        for (int i = 0; i < n; i++) {
            lifts[i] = new Lift(nextInt(), nextInt());
        }
        Arrays.sort(lifts);
        int end = lifts[n - 1].b;
        int[] ans = new int[end];
        int it = 0;
        try {
            for (int i = 0; i <= end; i++) {
                if (i < lifts[it].b) continue;
                while (it < n && lifts[it].b < i) it++;

                int cou = 0;
                while (it < n && lifts[it].a == lifts[it].b) {
                    cou++;
                    it++;
                }

                while (it < n && lifts[it].b == i) {
                    ans[i] = Math.max(ans[i], cou + ans[lifts[it].a] + 1);
                    it++;
                }
            }
        } catch (Exception e) {
            System.err.println("Случилась хуйня");
        }
        pw.println(Arrays.stream(ans).max().orElse(0));
    }

    static class Lift implements Comparable<Lift> {
        int a;
        int b;

        public Lift(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Lift o) {
            if (b == o.b) {
                return o.a - a;
            } else {
                return b - o.b;
            }
        }
    }
}

/* Test1
7
2 6
5 6
2 5
2 2
6 8
2 2
0 2
*/

/* Answer1
6
*/
