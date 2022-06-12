import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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

    static int[] s;
    static int[] arr;
    static String t;
    static int cou;

    private static void solve() {
        s = nextLine().chars().map(c -> c - 'a').toArray();
        arr = new int[26];
        t = nextLine();
        if (s.length < t.length()) {
            pw.println(-1);
            return;
        }

        for (char c : t.toCharArray()) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < s.length; i++) {
            if (s[i] < 0 || s[i] >= 26) {
                s[i] = 26;
            }
        }

        for (int i = 0; i < t.length(); i++) {
            arr[s[i]]--;
        }

        cou = 0;
        for (int j : arr) {
            cou += Math.abs(j);
        }

        if (cou == 2) {
            pw.println(0);
            return;
        }

        for (int i = t.length(); i < s.length; i++) {
            int c1 = s[i - t.length()];
            int c2 = s[i];

            int k1 = Math.abs(arr[c1]);
            arr[c1]++;
            if (Math.abs(arr[c1]) > k1) {
                cou++;
            } else {
                cou--;
            }

            int k2 = Math.abs(arr[c2]);
            arr[c2]--;
            if (Math.abs(arr[c2]) > k2) {
                cou++;
            } else {
                cou--;
            }

            if (cou == 2) {
                pw.println(i - t.length() + 1);
                return;
            }
        }
        pw.println(-1);
    }
}
