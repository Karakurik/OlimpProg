import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class G {
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
        String n = nextLine();
        String m = nextLine();
        int zeros = 0;
        if (n.charAt(0) == '-') {
            zeros++;
            n = n.substring(1);
        }
        if (m.charAt(0) == '-') {
            zeros++;
            m = m.substring(1);
        }
        if (zeros%2==1) pw.print("-");
        pw.println(mult(n, m));
    }

    private static String mult(String n, String m) {
        if (n.length() < 9 && m.length() < 9) return String.valueOf(Long.parseLong(n) * Long.parseLong(m));

        String a = n.substring(0, n.length() / 2);
        String b = n.substring(n.length() / 2);
        String c = m.substring(0, m.length() / 2);
        String d = m.substring(m.length() / 2);
        StringBuilder z1 = getZeros(b.length());
        StringBuilder z2 = getZeros(d.length());

        return new BigInteger(mult(a, c) + z1 + z2)
                .add(new BigInteger(mult(b, c) + z2))
                .add(new BigInteger(mult(a, d) + z1))
                .add(new BigInteger(mult(b, d)))
                .toString();
    }

    private static StringBuilder getZeros(int length) {
        StringBuilder sb = new StringBuilder();
        StringBuilder shubl = new StringBuilder("0");
        while (length >0) {
            if (length %2 == 1) {
                length--;
                sb.append(shubl);
            } else {
                length /= 2;
                shubl.append(shubl);
            }
        }
        return sb;
    }
}
