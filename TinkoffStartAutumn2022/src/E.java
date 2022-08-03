import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E {
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
        int q = nextInt();
        Map<String, Integer> ans = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            ans.put(s, i+1);
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() > 0) {
                String str = sb.toString();
                if (!map.containsKey(str)) {
                    map.put(str, new ArrayList<>());
                }
                map.get(str).add(s);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        for (List<String> e : map.values()) {
            Collections.sort(e);
        }

        for (int i = 0; i < q; i++) {
            String str = nextLine();
            int k = Integer.parseInt(str.split(" ")[0]);
            String sub = str.split(" ")[1];
            try {
                pw.println(ans.getOrDefault(map.get(sub).get(k-1), -1));
            } catch (Exception e) {
                pw.println(-1);
            }
        }
    }
}

/* Test1
5 3
ad
a
abc
aboba
b
3 a
2 ab
1 b
*/

/* Answer1
4
4
5
*/
