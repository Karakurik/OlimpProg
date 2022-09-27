import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

public class D2Huck {
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

    static boolean[][] cards = new boolean[9][4];


    private static void solve() {
        List<String> list = new ArrayList<>();
        list.add("KS QD 8D QC 8S 8C JD 9H AC TH 9S 9D QH 7H 8H TS 7S 9C\n" +
                "6D JS 7D KH QS TC AD AS KC 6C 7C TD AH KD 6S JC JH 6H\n");
        list.add("JC JS 8S TD JD KH 7D 9C KC TH QD 8D 7H TC KD 9H 8C 6D\n" +
                "7S AC QH AD 8H TS 6H JH 6C AH 7C 6S 9D QC AS QS KS 9S\n");

        String s = generateString();

        for (String str: list) {
            pw.println(str);
            pw.println(s);
        }
    }

    static Random random = new Random();
    private static String generateString() {
        cards = new boolean[9][4];
        int cou = 0;
        while (cou < 18) {
            int i = random.nextInt(9);
            int j = random.nextInt(4);
            if (!cards[i][j]) {
                cou++;
                cards[i][j] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                if (cards[i][j]) {
                    sb.append(str1.charAt(i)).append(str2.charAt(j)).append(" ");
                }
            }
        }
        sb.append("\n");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                if (!cards[i][j]) {
                    sb.append(str1.charAt(i)).append(str2.charAt(j)).append(" ");
                }
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    static String str1 = "6789TJQKA";
    static String str2 = "CDSH";
}
