import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PBigInt {
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

    static LinkedList<Pair> list;

    private static void solve() {
        int n = nextInt();
        BigInteger k = new BigInteger(String.valueOf(nextLong()));
        String s = nextLine();
        BigInteger cou = BigInteger.ZERO;
        BigInteger localCou = BigInteger.ZERO;
        list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                localCou = localCou.multiply(BigInteger.TEN).add(new BigInteger(String.valueOf(Character.getNumericValue(c))));
            } else {
                if (localCou.equals(BigInteger.ZERO)) localCou = BigInteger.ONE;
                cou = cou.add(localCou);
                list.add(new Pair(c, localCou));
                localCou = BigInteger.ZERO;
            }
        }
        k = k.mod(cou);

        while (k.compareTo(BigInteger.ZERO) > 0) {
            if (k.compareTo(list.getFirst().cou) >= 0) {
                add(list.getFirst());
                k = k.subtract(list.getFirst().cou);
                list.removeFirst();
            } else {
                list.getFirst().cou = list.getFirst().cou.subtract(k);
                add(new Pair(list.getFirst().c, k));
                k = BigInteger.ZERO;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Pair p: list) {
            if (p.cou.compareTo(BigInteger.ONE) > 0) {
                ans.append(p.cou);
            }
            ans.append(p.c);
        }
        pw.println(ans);
    }

    public static void add (Pair p) {
        if (list.getLast().c == p.c) {
            list.getLast().cou = list.getLast().cou.add(p.cou);
        } else {
            list.add(p);
        }
    }

    private static class Pair {
        char c;
        BigInteger cou;

        public Pair(char c, BigInteger cou) {
            this.c = c;
            this.cou = cou;
        }
    }
}
