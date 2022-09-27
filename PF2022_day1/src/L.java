import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class L {
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

    private static void solve() {
        int n = nextInt();
        int l = nextInt();
        int k = nextInt();
        int[][] arr = new int[n][l];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                arr[i][j] = -1;
            }
        }
        String s = nextLine();
        int[] cou = new int[26];
        int id = 0;
        for (char c : s.toCharArray()) {
            cou[c - 'a']++;
        }
        int newJ = 0;
        for (int i = 0; i < l; i++) {
            for (int j = newJ; j < k; j++) {
                while (cou[id] == 0) id++;
                arr[j][i] = id;
                cou[id]--;
            }
            for (int j = k - 2; j >= 0; j--) {
                if (arr[k - 1][i] != arr[j][i]) {
                    newJ = j + 1;
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                if (arr[i][j] == -1) {
                    while (cou[id] == 0) id++;
                    arr[i][j] = id;
                    cou[id]--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < l; j++) {
                sb.append((char) ('a' + arr[i][j]));
            }
            pw.println(sb);
        }
    }
}
