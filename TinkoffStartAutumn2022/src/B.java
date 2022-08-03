import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        Map<Set<String>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<String> set = new HashSet<>(Arrays.asList(nextLine().split(" ")));
            map.put(set, map.containsKey(set) ? map.get(set) + 1 : 1);
        }
        int ans = 0;
        for (Integer i : map.values()) {
            ans = Math.max(ans, i);
        }
        pw.println(ans);
    }
}

/* Test1
5
MIKHAIL VLADISLAV GRIGORY
VLADISLAV MIKHAIL GRIGORY
IVAN ILYA VLADIMIR
ANDREY VLADIMIR ILYA
VLADIMIR IVAN ANDREY
*/

/* Answer1
2
*/
