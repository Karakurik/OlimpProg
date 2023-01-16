import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
        int n = nextInt();
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
//        Collections.shuffle(list);
        if (n == 2) {
            pw.println(list.get(0));
            pw.println(list.get(2));
        }
        for (int i = 0; i < n; i++) {
            pw.println(list.get(i));
        }
    }

}
