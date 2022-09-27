import java.io.*;
import java.util.*;

public class J {
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

    public static void main(String[] args) throws FileNotFoundException {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            if (!map.containsKey(t)) map.put(t, 0);
            map.put(t, map.get(t) + 1);
        }
        List<Integer> col = new ArrayList<>(map.values());
        Collections.sort(col);

        int ansCou = -1;
        for (int s = 1; s <= col.get(0) + 1; s++) {
            boolean flag = true;
            int cou = 0;
            for (var x : map.values()) {
                int p = x / s;
                int q = x % s;
                if (q == 0 || p + q >= s - 1) {
                    cou += p;
                    if (q > 0) cou++;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if (ansCou == -1 || ansCou > cou) {
                    ansCou = cou;
                }
            }
        }
        pw.println(ansCou);
    }
}
