import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class B {
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
        int n = nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            String s = nextLine();
            String s1 = s.substring(0, s.indexOf('@'));
            String s2 = s.substring(s.indexOf('@'));
            StringBuilder sb = new StringBuilder();
            for(char c: s1.toCharArray()) {
                if (c != '.') {
                    sb.append(c);
                }
            }
            s1 = sb.toString();
            if (s1.indexOf('-') >= 0) {
                s1 = s1.substring(0, s1.indexOf('-'));
            }
            if (s2.indexOf('.') >= 0) {
                s2 = s2.substring(0, s2.lastIndexOf('.'));
            }
            set.add(s1 + s2);
        }
        pw.println(set.size());
    }
}
