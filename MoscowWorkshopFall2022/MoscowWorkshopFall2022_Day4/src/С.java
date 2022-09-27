import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class С {
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
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20000; i++) {
            sb.append((char)(new Random().nextInt(26)));
        }
        String str = sb.toString();


        Set<StringBuilder> set = new HashSet<>();
        List<StringBuilder> list = new ArrayList<>();
        for (char c: str.toCharArray()) {
            for (StringBuilder s: list) {
                s.append(c);
                set.add(s);
            }
            StringBuilder newSb = new StringBuilder(c);
            list.add(newSb);
            set.add(newSb);
            pw.println(set.size());
        }
    }

    static class State {
        int len;
        int suffLink;
        Map<Character, Integer> next;

        public State(int len, int suffLink) {
            this.len = len;
            this.suffLink = suffLink;
        }
    }
}
