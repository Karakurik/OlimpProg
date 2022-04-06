import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class F {
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
        int h = nextInt();
        int m = nextInt();
        int k = nextInt();
        List<Integer>[] arr = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int hi = nextInt();
            int mi = nextInt();
            arr[mi].add(i+1);
        }
        int cou = 0;
        for (int i = m - k+1; i < m; i++) {
            cou += arr[i].size();
        }
        for (int i = m/2-k+1; i < m/2; i++) {
            cou += arr[i].size();
        }
        int ansCand = 0;
        int candCou = cou;
        for (int i = 0; i + 1 < m / 2; i++) {
            cou -= arr[(m + i - k+1) % m].size();
            cou -= arr[m/2 + i - k+1].size();
            cou += arr[i].size();
            cou += arr[m/2+i].size();
            if (cou < candCou) {
                candCou = cou;
                ansCand = i + 1;
            }
        }
        pw.println(candCou + " " + ansCand);
        for (int i = ansCand-k+1; i < ansCand; i++) {
            for(Integer t: arr[(i+m)%m]) pw.print(t+" ");
        }
        for (int i = ansCand + m/2 - k + 1; i < ansCand + m/2; i++) {
            for(Integer t: arr[(i+m)%m]) pw.print(t+" ");
        }
    }
}
