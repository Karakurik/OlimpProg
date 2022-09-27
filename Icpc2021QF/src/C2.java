import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C2 {
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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
//        pw = new PrintWriter(new FileWriter("output.txt"));
        pw = new PrintWriter(System.out);

        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
//        solve();
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int k = nextInt();
        int x = nextInt();
        int y = nextInt();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nextToken().equals("A")) {
                A.add(nextInt());
            } else {
                B.add(nextInt());
            }
        }
        A.sort((o1, o2) -> o2 - o1);
        B.sort((o1, o2) -> o2 - o1);
        long ans = 0;

        // Get all from A
        int couA = 0;
        for (int i = 0; i < 2 * k; i++) {
            if (A.size() > i) {
                ans += A.get(couA);
                couA++;
                if (couA > k) {
                    ans -= x;
                }
            }
        }

        // Get 2*k-couA from B
        int couB = 0;
        for (int i = 0; i < 2 * k - couA; i++) {
            if (B.size() > i) {
                ans += B.get(couB);
                couB++;
                if (couB > k) {
                    ans -= y;
                }
            }
        }
        long potAns = ans;
        while (couA > 0 && couB < B.size()) {
            // +1 from B
            ans += B.get(couB);
            couB++;
            if (couB > k) {
                ans -= y;
            }

            // -1 from A
            if (couA > k) {
                ans += x;
            }
            couA--;
            ans -= A.get(couA);

            // update answer
            potAns = Math.max(potAns, ans);
        }
        pw.println(potAns);
    }
}