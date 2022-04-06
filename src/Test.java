import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Test {
    static BufferedReader br;
    static PrintWriter pw;
    static StringTokenizer st;

    static String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static String nextLine() throws IOException {
        return br.readLine();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static Long nextLong() {
        return Long.parseLong(nextToken());
    }

    static char nextChar() throws IOException {
        return (char) br.read();
    }

    static char getChar() {
        return nextToken().charAt(0);
    }

    static int[] intArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    static long[] longArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    private Test () {

    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() throws IOException {
        int n = nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        if (n <= 2) {
            pw.println("YES");
            return;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long h = (long) arr[i] * arr[j];
                int t = (int) Math.ceil(Math.sqrt(h));
                if (set.contains(t)) {
                    pw.print("NO");
                    return;
                } else {
                    set.add(t);
                }
            }
        }
        pw.println("YES");
    }
}
