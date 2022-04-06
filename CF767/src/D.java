import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class D {
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
        t = nextInt();
        while (t-- > 0) {
            pw.println(solve()?"YES":"NO");
        }
        pw.close();
    }

    private static boolean solve() {
        int n = nextInt();
        String[] arr = new String[n];
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = nextToken();
        }
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            if (s.length()==1) return true;
            String sh = new StringBuilder(s).reverse().toString();
            if (s.equals(sh)) return true;
            if (s.length()==2) {
                if (set.contains(sh)) return true;
                for (int j = 0; j < 26; j++) {
                    if (set.contains(sh + (char)('a'+j))) return true;
                }
            }
            if (s.length()==3) {
                if (set.contains(sh)) return true;
                if (set.contains(sh.substring(0,2))) return true;
            }
            set.add(s);
        }
        return false;
    }
}
