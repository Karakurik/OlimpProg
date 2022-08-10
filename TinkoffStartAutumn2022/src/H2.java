import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class H2 {
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
        int m = nextInt();
        Map<String, Set<String>> start = new HashMap<>();
        Map<String, Set<String>> end = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = nextLine();

            StringBuilder sb = new StringBuilder(s);
            while (sb.length() > 0) {
                String str = sb.toString();
                if (!start.containsKey(str)) {
                    start.put(str, new HashSet<>());
                }
                start.get(str).add(s);
                sb.deleteCharAt(sb.length() - 1);
            }

            sb = new StringBuilder(s);
            while (sb.length() > 0) {
                String str = sb.toString();
                if (!end.containsKey(str)) {
                    end.put(str, new HashSet<>());
                }
                end.get(str).add(s);
                sb.deleteCharAt(0);
            }
        }

        HashSet<String> emptyHashSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            String[] arr = nextLine().split(" ");
            Set<String> setAns = new HashSet<>(start.getOrDefault(arr[0], emptyHashSet));
            setAns.retainAll(end.getOrDefault(arr[1], emptyHashSet));
            int l = arr[0].length() + arr[1].length();
            int ans = 0;
            for (String s : setAns) {
                if (s.length() >= l) ans++;
            }
            pw.println(ans);
        }
    }
}

/* Test1
2 3
ATSR
ASR
S R
AT R
A R
*/

/* Answer1
0
1
2
*/
