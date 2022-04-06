import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i+1]=nextInt()%k;
        }
        Map<Integer, Integer> ans = new HashMap<>();
        int cou = 0;

        for (int i = 1; i <=n; i++) {
            int t = 0;
            for (int j = 0; j < m && i+j < n+1; j++) {
                t += arr[i+j];
                if (t==k) {
                    ans.put(i, j+1);
                    i = i+j;
                    cou+=j;
                    break;
                }
            }
        }
        pw.println(cou);
        pw.println(ans.size());
        for (Map.Entry<Integer, Integer> e: ans.entrySet()) {
            pw.println(e.getKey() + " " + e.getValue());
        }
    }
}