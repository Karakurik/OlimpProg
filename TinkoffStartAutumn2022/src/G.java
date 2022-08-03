import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G {
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

        global = new ArrayList[Z];
        for (int i = 0; i < Z; i++) {
            global[i] = new ArrayList<>();
        }
        String s = nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            global[c - charA].add(i + 1);
        }
        for (int i = 0; i < Z; i++) {
            Collections.sort(global[i]);
        }

        int t = 1;
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static List<Integer>[] global;
    private static final int Z = 26;
    private static final char charA = 'a';

    private static void solve() {
        leftTest = nextInt();
        rightTest = nextInt();
        int ans = 0;
        curPosition = leftTest;
        for (int i = 0; i < Z; i++) {
            if (global[i].isEmpty()) continue;

            int findResult = funFind(i);
            if (findResult != -1) {
                if (findResult < curPosition) {
                    ans += findResult - leftTest + 1 + rightTest - curPosition;
                } else {
                    ans += findResult - curPosition;
                }
                curPosition = findResult;
            }
        }
        pw.println(ans);
    }

    static int curPosition = 1;
    static int leftTest;
    static int rightTest;

    private static int funFind(int i) {
        int idRd = boundR(rightTest, global[i]);
        int idCurd = boundR(curPosition, global[i]);
        if (idCurd >= leftTest) {
            return idCurd;
        }
        if (idRd >= leftTest) {
            return idRd;
        }
        return -1;
    }

    private static int boundR(int x, List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (list.get(m) > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        while (m >= 0 && list.get(m) > x) {
            m--;
        }
        return m != -1 ? list.get(m) : -1;
    }
}

/* Test1
hello
3
1 5
1 2
2 5
*/

/*
9
2
3
*/
