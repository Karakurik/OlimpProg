import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        List<Integer>[][] arr = new List[n+1][3];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            String[] s = nextLine().split(" ");

            if (s[2].equals("g")) {
                arr[Integer.parseInt(s[0])][0].add(Integer.parseInt(s[1]));
            }

            if (s[2].equals("y")) {
                arr[Integer.parseInt(s[0])][1].add(Integer.parseInt(s[1]));
            }

            if (s[2].equals("r")) {
                arr[Integer.parseInt(s[1])][2].add(Integer.parseInt(s[0]));
            }
        }
        long[][] ans2 = new long[n + 1][n + 1];
        for (int f = 1; f < n+1; f++) {
            for (int s: arr[f][0]) {
                for (int t: arr[s][1]) {
                    ans2[f][t]++;
                }
            }
        }
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            int x = nextInt();
            int y = nextInt();
            long ans = 0;
            for(int t: arr[y][2]) {
                ans += ans2[x][t];
            }
            pw.println(ans);
        }
    }
}
