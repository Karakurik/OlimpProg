import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Task4_2 {
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

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    static int n;
    private static void solve() throws Exception {
        n = nextInt();
//        long start = System.currentTimeMillis();
        points = new double[n][2];
        double vnUgol = Math.PI - (n - 2) * Math.PI / n;
        points[0][0] = 0;
        points[0][1] = 0;
        points[1][0] = 0;
        points[1][1] = 1;
        for (int i = 2; i < n; i++) {
            points[i][0] = points[i - 1][0] + Math.sin(vnUgol * (i - 1));
            points[i][1] = points[i - 1][1] + Math.cos(vnUgol * (i - 1));
        }
        pw.println(razbit(0, n - 1));
//        pw.println(System.currentTimeMillis() - start);
    }

    static double[][] points;
    static Map<Pair, Double> answers = new HashMap<>();
    static Map<Integer, Double> answersLR = new HashMap<>();

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;

            return b == pair.b && a == pair.a || a == pair.b && b == pair.a;
        }

        @Override
        public int hashCode() {
            if (a < b) return 1031 * a + 31 * b;
            return 1031 * b + 31 * a;
        }
    }

    private static double razbit(int f, int r) throws Exception {
        if (f == r) {
            throw new Exception();
        }
        if (!answersLR.containsKey(r - f)) {
            double ansSqrt = 0.0;
            for (int s = f + 1; s <= r; s++) {
                if (r == n - 1 && s > r/2 + 2) break;
                for (int t = s + 1; t <= r; t++) {
                    double sqr = 0;
                    try {
                        sqr += razbit(f + 1, s - 1);
                        sqr += razbit(s + 1, t - 1);
                        sqr += razbit(t + 1, r);
                        sqr += square(f, s, t);
                    } catch (Exception e) {
                        sqr = 0;
                    }
                    ansSqrt = Math.max(ansSqrt, sqr);
                }
            }
            answersLR.put(r - f, ansSqrt);
        }

        return answersLR.get(r - f);
    }

    private static double square(int f, int s, int t) {
        Pair pair = new Pair(s - f, t - s);
        if (!answers.containsKey(pair)) {
            double a = Math.sqrt(pow2(points[f][0] - points[s][0]) + pow2(points[f][1] - points[s][1]));
            double b = Math.sqrt(pow2(points[t][0] - points[s][0]) + pow2(points[t][1] - points[s][1]));
            double c = Math.sqrt(pow2(points[f][0] - points[t][0]) + pow2(points[f][1] - points[t][1]));
            double p = (a + b + c) / 2;
            answers.put(pair, Math.sqrt(p * (p - a) * (p - b) * (p - c)));
        }

        return answers.get(pair);
    }

    private static double pow2(double a) {
        return a * a;
    }
}

/* test1
3
*/

/* answer1
0.433013
*/

/* test2
10
*/

/* answer2
3.553212
*/
