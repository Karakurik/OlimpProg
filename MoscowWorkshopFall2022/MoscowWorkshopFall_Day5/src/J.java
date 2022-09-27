import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class J {
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
        t = nextInt();
        for (int j = 1; j <= t; j++) {
            pw.printf("Case #%d: \n", j);
//            for (int i = 1; i < 1000000000; i++) {

                solve();
//            }
        }

        pw.close();
    }

    private static void solve() {
//        String s = String.valueOf(n);
        String s = nextLine();
//        if (n == 110) {
//            pw.println();
//        }
//        pw.println("FUCK" + s);
        BigInteger val = new BigInteger(s);
        List<String> ans = new ArrayList<>();
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            pw.println(1);
            pw.println(s);
            return;
        }
        while (val.toString().length() > 1) {
            s = val.toString();
            int len = s.length();
            StringBuilder sb = new StringBuilder(s.substring(0, len / 2));
            String valMinusHalf = sb.toString();
            if (len % 2 == 1) {
                valMinusHalf += s.charAt(len / 2);
            }
            String valMinus = valMinusHalf + sb.reverse();
            BigInteger val2 = new BigInteger(valMinus);
            if (val2.compareTo(val) > 0) {
                val2 = new BigInteger(valMinusHalf);
                val2 = val2.subtract(BigInteger.ONE);
                valMinusHalf = val2.toString();
                sb = new StringBuilder(valMinusHalf);
                if (sb.toString().equals("0")) sb.deleteCharAt(0);
                if (valMinusHalf.length() % 2 == 1 && sb.length()*2 < val.toString().length()-1) {
                    sb.append(9);
                }
                sb.reverse();
                valMinus = valMinusHalf + sb;
            }
            val2 = new BigInteger(valMinus);
            if (val2.compareTo(val) > 0) {
                StringBuilder temp = new StringBuilder(val2.toString());
                temp.deleteCharAt(val2.toString().length()/2);
                val2 = new BigInteger(temp.toString());
            }
            val = val.subtract(val2);
            ans.add(val2.toString());
        }
        if (!val.equals(BigInteger.ZERO)) {
            ans.add(val.toString());
        }
        pw.println(ans.size());
        for (String b : ans) {
            pw.println(b);
        }
    }
}
