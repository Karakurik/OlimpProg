import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class B {
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
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = nextLine().split(" ");
            int a = Integer.parseInt(s[1]);
            for (int j = 2; j < 4; j++) {
                a = Math.max(a, Integer.parseInt(s[j]));
            }
            list.add(a);
        }
        Collections.sort(list);
        int ans = list.get((list.size()-1)/2);
        pw.println(ans);
    }
}
