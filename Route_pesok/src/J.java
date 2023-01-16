import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    static Map<String, List<String>> map;

    private static void solve() {
        int n = nextInt();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = nextLine();
            StringBuilder sb = new StringBuilder(str).reverse();
            while (sb.length() >= 0) {
                String helpStr = sb.toString();
                if (!map.containsKey(helpStr)) {
                    map.put(helpStr, new ArrayList<>());
                }
                map.get(helpStr).add(str);
                if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
                else break;
            }
        }

        int q = nextInt();
        for (int i = 0; i < q; i++) {
            go();
        }
    }

    private static void go() {
        String str = nextLine();
        StringBuilder sb = new StringBuilder(str).reverse();
        while (sb.length() >= 0) {
            String helpStr = sb.toString();
            if (map.containsKey(helpStr)) {
                for (String cand : map.get(helpStr)) {
                    if (!cand.equals(str)) {
                        pw.println(cand);
                        return;
                    }
                }
            }
            if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
            else break;
        }

    }

}
