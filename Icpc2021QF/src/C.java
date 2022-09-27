import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {
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
        int idA = 0;
        int idB = 0;
        int cou = 0;
        while (cou < 2 * k) {
            if (A.size() > idA) {
                if (idA >= k) {
                    ans -= y;
                }
                ans += A.get(idA++);
                cou++;
            }
            if (B.size() > idB) {
                if (idB >= k) {
                    ans -= y;
                }
                ans += B.get(idB++);
                cou++;
            }
        }
        for (int i = idB; i < B.size(); i++) {
            try {
                if (B.get(idB) - y > A.get(idA - 1)) {
                    ans += B.get(idB) - y - A.get(idA - 1);
                    idB++;
                    idA--;
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }
        for (int i = idA; i < A.size(); i++) {
            try {
                if (A.get(idA) - x > B.get(idB - 1)) {
                    ans += A.get(idA) - x - B.get(idB - 1);
                    idA++;
                    idB--;
                } else {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }
        pw.println(ans);
    }
}