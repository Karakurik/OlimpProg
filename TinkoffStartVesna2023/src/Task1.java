import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Task1 {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }

    static char nextChar() {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
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
        nextInt();
        char probel = ' ';
        String s = nextLine();
        StringBuilder sb = new StringBuilder(nextLine());
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == probel) {
                sb.insert(i, probel);
            }
        }
        pw.println(Arrays.stream(sb.toString().split(String.valueOf(probel))).filter(t -> t.contains("BB") || t.contains("YY")).count());
    }
}

/* test1
7
Tinkoff
BYBYBYB
*/

/* answer1
0
*/

/* test2
27
Algorithms and Data Structures
BBBBBBBBBBBYBYYYYBBBBBBBBBB
*/

/* answer2
3
*/
