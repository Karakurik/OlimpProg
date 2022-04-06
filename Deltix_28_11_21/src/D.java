import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class D {
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
        n = nextInt();
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static int n;
    static int ans = 0;
    static List<HashSet<Integer>> list = new ArrayList<>();


    private static void solve() {
        int x = nextInt();
        int y = nextInt();
        for (int j = 0; j < list.size(); j++) {
            for (int k = j + 1; k < list.size(); k++) {
                if (list.get(j).contains(x) && list.get(k).contains(y)
                        || list.get(j).contains(y) && list.get(k).contains(x)) {
                    ans = Math.max(ans, list.get(j).size() + list.get(k).size());
                    list.get(j).addAll(list.get(k));
                    list.remove(k);
                    pw.println(ans-1);
                    pw.flush();
                    return;
                }
            }
        }
        for (HashSet<Integer> s:list) {
            if (s.contains(x) && s.contains(y)) {
                pw.println(ans-1);
                pw.flush();
                return;
            }
        }
        for (HashSet<Integer> s:list) {
            if (s.contains(x)) {
                s.add(y);
                ans = Math.max(ans, s.size());
                pw.println(ans-1);
                pw.flush();
                return;
            }
            if (s.contains(y)) {
                s.add(x);
                ans = Math.max(ans, s.size());
                pw.println(ans-1);
                pw.flush();
                return;
            }
        }
        HashSet<Integer> s = new HashSet<>();
        s.add(x);
        s.add(y);
        list.add(s);
        ans = Math.max(2, ans);
        pw.println(ans-1);
        pw.flush();
    }
}