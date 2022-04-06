import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class N {
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
            solve();
        }
        pw.close();
    }

    private static void solve() {
        String s = "aeiou";
        nextLine();
        String s1 = nextLine().toLowerCase();
        int cou = 0;
        int couY = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s.indexOf(s1.charAt(i))>=0) cou++;
            if (s1.charAt(i)=='y') couY++;
        }
        if (cou<=5 && cou+couY>=5) {
            s1 = nextLine().toLowerCase();
            cou = 0;
            couY = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s.indexOf(s1.charAt(i))>=0) cou++;
                if (s1.charAt(i)=='y') couY++;
            }
            if (cou<=7 && cou+couY>=7) {
                s1 = nextLine().toLowerCase();
                cou = 0;
                couY = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if (s.indexOf(s1.charAt(i))>=0) cou++;
                    if (s1.charAt(i)=='y') couY++;
                }
                if (cou<=5 && cou+couY>=5) {
                    pw.println("YES");
                    pw.flush();
                    return;
                }
            } else {
                for (int i = 0; i < 1; i++) {
                    nextLine();
                }
            }
        } else {
            for (int i = 0; i < 2; i++) {
                nextLine();
            }
        }
        pw.println("NO");
        pw.flush();
    }
}