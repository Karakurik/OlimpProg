import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class D2Test {
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
        pw.println("KS QD 8D QC 8S 8C JD 9H AC TH 9S 9D QH 7H 8H TS 7S 9C\n" +
                "6D JS 7D KH QS TC AD AS KC 6C 7C TD AH KD 6S JC JH 6H\n" +
                "\n" +
                "6D 6S 7S 7H 8D 8H 9D 9S 9H JC JS QS QH KD KH AC AS AH \n" +
                "6C 6H 7C 7D 8C 8S 9C TC TD TS TH JD JH QC QD KC KS AD");
    }

}
