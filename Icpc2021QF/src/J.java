import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

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

    static int[][] arr;
    static ArrayList<Long>[] currentX;
    static int n;
    static int k;
    static long rait;
    private static void solve() {
        n = nextInt();
        k = nextInt();
        long x = nextLong();
        rait = x;
        arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = nextInt();
            }
        }
        currentX = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            currentX[i] = new ArrayList<>();
        }
        long ans = game(0, x);
        pw.println(ans);
    }

    private static Long game(int gn, long x) {
        if (gn == n) return x;
        if (currentX[gn].contains(x)) {
            return null;
        }
        currentX[gn].add(x);
        long x1 = x;
        long x2 = x;
        if (arr[gn][2] == 1) {
            x1+= arr[gn][0];
        } else {
            x1-= arr[gn][1];
        }
        if (arr[gn][3] == 1) {
            x2 += arr[gn][0];
        } else  {
            x2 -= arr[gn][1];
        }

        if (x > rait+k) {
            return game(gn+1, x2);
        }
        if (x < rait-k) {
            return game(gn+1, x1);
        }

        Long g1 = game(gn+1, x1);
        Long g2 = game(gn+1, x2);
        if (g1==null && g2==null){
            return null;
        } else if (g1==null) {
            return g2;
        } else if (g2==null) {
            return g1;
        } else {
            return Math.max(g1, g2);
        }
    }
}