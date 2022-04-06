import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

    static int n;
    static int[][] arr;
    static int[] ans;

    private static void solve() {
        n = nextInt();
        String s = nextLine();
        ans = new int[n];
        arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            ans[i] = s.charAt(i) - 'a';
        }

//        Arrays.fill(arr, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = -1;
            }
        }
        for (int i = 0; i < 4; i++) {
            count(i, 0);
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans = Math.max(ans, arr[0][i]);
        }
        pw.println(ans);
    }

    private static int count(int curAns, int cou) {
        if (cou == n) return 0;
        if (arr[cou][curAns] != -1) return arr[cou][curAns];
        int i1 = -1;
        int i2 = -1;
        if (curAns > 0) i1 = count(curAns - 1, cou + 1);
        if (curAns < 3) i2 = count(curAns + 1, cou + 1);
        int curScore = Math.max(Math.max(i1, i2), 0);
        if (ans[cou] == curAns) curScore++;
        arr[cou][curAns] = curScore;
        return curScore;
    }
}
