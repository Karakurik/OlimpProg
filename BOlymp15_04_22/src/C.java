import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static Map<Long, Long> map;
    static long a;
    static long b;
    private static void solve() {
       a = nextLong();
       b = nextLong();
       long x = nextLong();
//       map = new HashMap<>();
        if (x> a) {
            pw.println(x-b+1);
        }else {
            pw.println(a+1-b+1);
        }
//       pw.println(calc(x));
    }

    public static long calc(long x) {
        if (map.containsKey(x)) {
            return map.get(x);
        }
        if (x>a) {
            map.put(x, x-b+1);
            return x-b+1;
        }
        map.put(x, calc(calc(x+b)));
        return map.get(x);
    }
}
