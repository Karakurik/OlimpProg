import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class H {
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

    static Set<String> palindromes;
    private static void solve() {
        StringBuilder s = new StringBuilder(nextLine());
        palindromes = new HashSet<>();
        int n = (int) Math.pow(2, s.length());
        for (int i = 1; i < n; i++) {
            StringBuilder cand = new StringBuilder();
            int id = 0;
            int t = i;
            while (t > 0) {
                if (t % 2 == 1) {
                    cand.append(s.charAt(id));
                }
                id++;
                t /= 2;
            }
            if (cand.toString().equals(cand.reverse().toString())) {
                palindromes.add(cand.toString());
            }
        }
        int ans = 16;
        for (String palindrome : palindromes) {
            ans = Math.min(ans, check(new StringBuilder(s), palindrome, 0));
        }
        pw.println(ans);
    }

    public static int check(StringBuilder s, String palindrome, int cou) {
        if (s.length() == 0) return cou;

        int index = 0;
        for (char c : palindrome.toCharArray()) {
            index = s.indexOf(String.valueOf(c), index);
            if (index == -1) return 100;
            s.deleteCharAt(index);
        }

        int ans = 16;
        for (String pal : palindromes) {
            ans = Math.min(ans, check(new StringBuilder(s), pal, cou + 1));
        }

        return ans;
    }
}
