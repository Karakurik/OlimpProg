import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class T3 {
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
        char[] arr = nextLine().toCharArray();
        int k = nextInt();
        int cou = 0;
        int id = -1;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '.') cou++;
            if (cou > k) {
                ans = Math.max(ans, i - id - 1);
                id++;
                while (arr[id] != '.') id++;
                cou--;
                ans = Math.max(ans, i - id);
            }
        }
        if (id == -1) {
            ans = arr.length;
        } else {
            ans = Math.max(ans, arr.length - id - 1);
        }
        pw.println(ans);
    }
}

/*
X...X..XX
3
*/

/*
XXXX
239
*/
