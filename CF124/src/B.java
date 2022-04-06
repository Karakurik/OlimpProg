import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

        List<Integer> list = new ArrayList<>();
        int i =1;
        list.add(i);
        while (3*i<=1_000_000_000) {
            i = 3*i;
            list.add(i);
        }


        t = nextInt();
        while (t-- > 0) {
            int n = nextInt();
            if (n<=list.size()) {
                pw.println("YES");
                for (int j = 0; j < n; j++) {
                    pw.print(list.get(j) + " ");
                }
                pw.println();
            } else {
                pw.println("NO");
            }
        }
        pw.close();
    }

    private static void solve() {


    }
}
