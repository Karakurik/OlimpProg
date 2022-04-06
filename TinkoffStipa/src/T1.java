import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class T1 {
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
        String x = nextLine();
        int n = nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLine();
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.equals(o2)) return 0;
            for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                if (x.indexOf(o1.charAt(i)) < x.indexOf(o2.charAt(i))) {
                    return -1;
                }
                if (x.indexOf(o1.charAt(i)) > x.indexOf(o2.charAt(i))) {
                    return 1;
                }
            }
            return o1.length() - o2.length();
        });
        for (String s : arr) {
            pw.println(s);
        }
    }
}

/*
zyxwvutsrqponmlkjihgfedcba
6
abd
bsk
ak
a
b
ldlajd
*/
