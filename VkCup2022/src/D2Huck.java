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
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TC TD JC JD QC QD KC KD AC AD\n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TS TH JS JH QS QH KS KH AS AH\n");
        list.add("6C 6D 7C 7D 8D 8S 8H 9C 9D TC TD JC JD QC QD KC KD AC\n" +
                "6S 6H 7S 7H 8C 9S 9H TS TH JS JH QS QH KS KH AD AS AH\n");
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TC TD JC JD QC QD KD KH AD AH\n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TS TH JS JH QS QH KC KS AC AS\n");
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TC TD JC JD QD QH KD KH AD AH \n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TS TH JS JH QC QS KC KS AC AS\n");
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TC TD JD JH QD QH KD KH AD AH\n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TS TH JC JS QC QS KC KS AC AS\n");
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TD TH JD JH QD QH KD KH AD AH\n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TC TS JC JS QC QS KC KS AC AS\n");
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TD TH JD JH QD QH KS KH AS AH\n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TC TS JC JS QC QS KC KD AC AD\n");
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TD TH JD JH QS QH KS KH AS AH\n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TC TS JC JS QC QD KC KD AC AD\n");
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TD TH JS JH QS QH KS KH AS AH\n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TC TS JC JD QC QD KC KD AC AD\n");
        list.add("6C 6D 7C 7D 8C 8D 9C 9D TS TH JS JH QS QH KS KH AS AH\n" +
                "6S 6H 7S 7H 8S 8H 9S 9H TC TD JC JD QC QD KC KD AC AD\n");
        list.add("6D 6H 7D 7H 8C 8D 9D 9H TS TH JS JH QS QH KS KH AS AH\n" +
                "6C 6S 7C 7S 8S 8H 9C 9S TC TD JC JD QC QD KC KD AC AD\n");
        list.add("6D 6H 7D 7H 8C 8D 9D 9H TD TH JS JH QS QH KS KH AS AH\n" +
                "6C 6S 7C 7S 8S 8H 9C 9S TC TS JC JD QC QD KC KD AC AD\n");
        list.add("6D 6H 7D 7H 8C 8D 9D 9H TD TH JD JH QS QH KS KH AS AH \n" +
                "6C 6S 7C 7S 8S 8H 9C 9S TC TS JC JS QC QD KC KD AC AD\n");

        String s = generateString();

        pw.println(s);
    }

    static Random random = new Random();
    private static String generateString() {
        cards = new boolean[9][4];
        cards[0][0] = false;
        cards[0][1] = true;
        cards[0][2] = false;
        cards[0][3] = true;
        cards[1][0] = false;
        cards[1][1] = true;
        cards[1][2] = false;
        cards[1][3] = true;
        cards[2][0] = true;
        cards[2][1] = true;
        cards[2][2] = false;
        cards[2][3] = false;
        cards[3][0] = false;
        cards[3][1] = true;
        cards[3][2] = false;
        cards[3][3] = true;
        cards[4][0] = false;
        cards[4][1] = true;
        cards[4][2] = false;
        cards[4][3] = true;
        cards[5][0] = false;
        cards[5][1] = true;
        cards[5][2] = false;
        cards[5][3] = true;
        cards[6][0] = false;
        cards[6][1] = false;
        cards[6][2] = true;
        cards[6][3] = true;
        cards[7][0] = false;
        cards[7][1] = false;
        cards[7][2] = true;
        cards[7][3] = true;
        cards[8][0] = false;
        cards[8][1] = false;
        cards[8][2] = true;
        cards[8][3] = true;

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
