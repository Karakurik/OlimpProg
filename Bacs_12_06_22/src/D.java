import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
        String[] str = new String[m];
        StringBuilder[] sb = new StringBuilder[m];
        for (int i = 0; i < m; i++) {
            sb[i] = new StringBuilder();
        }


        for (int i = 0; i < n; i++) {
            char[] chars = nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                sb[j].append(chars[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            str[i] = sb[i].reverse().toString();
        }
        Arrays.sort(str);
        int ans = 0;
        for (int i = 1; i < m; i++) {
            for (int j = i - 1; j < i; j++) {
                int cou = 0;
                while (str[i].charAt(cou) == str[j].charAt(cou)) cou++;
                ans = Math.max(ans, cou);
            }
        }
        pw.println(n - ans - 1);
    }

}