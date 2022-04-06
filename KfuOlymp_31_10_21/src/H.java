import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class H {
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
//        int t = nextInt();
//        while (t-- > 0) {
//            solve();
//        }
        solve();
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        char[] arr = nextLine().toCharArray();

        int result = 0;

        for (int i = 0; i < n-5; i++) {
            if (!isD(arr[i]) && !isD(arr[i+1]) && isD(arr[i+2])
            && isD(arr[i+3])&& isD(arr[i+4])&& isD(arr[i+5]))
                result++;
        }
        pw.println(result);
    }

    private static boolean isD(char c) {
        return c>='0' && c<='9';
    }

    private static boolean isB(char c) {
        return c>='A' && c<='Z';
    }
}