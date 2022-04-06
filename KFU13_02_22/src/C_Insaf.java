import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C_Insaf {
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

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int n = nextInt();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = nextToken();
            int c = nextInt();
            if (map.containsKey(s)) {
                map.put(s, map.get(s)+c);
            } else {
                map.put(s, c);
            }
        }
        int t = 1;
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static Map<String, Integer> map;

    private static void solve() {
        String s = nextToken();
        int ans = 0;
        String sol = null;
        if (map.containsKey(s)) {
            pw.println(map.get(s));
            return;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length()-1; i++) {
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(i+1);
            if (c1==c2) continue;
            sb.setCharAt(i, c2);
            sb.setCharAt(i+1, c1);
            if (map.containsKey(sb.toString())) {
                if (sol != null) {
                    pw.println(-1);
                    return;
                } else {
                    sol = sb.toString();
                    ans = map.get(sol);
                }
            }
            sb.setCharAt(i, c1);
            sb.setCharAt(i+1, c2);
        }
        pw.println(ans);
    }
}
