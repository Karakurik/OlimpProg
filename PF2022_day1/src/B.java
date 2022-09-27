import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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
        String s = nextLine();
        int cou = 0;
        char c = '$';
        for (char ch : s.toCharArray()) {
            if (ch != c) {
                cou++;
                c = ch;
            }
        }
        if (cou % 2 == 0) {
            pw.println(0);
            return;
        }

        int id = (cou+1) / 2;
        int[] ans = new int[id+1];
        char[] chars = new char[id+1];
        cou = 0;
        c = '$';
        int ansCou = 0;
        boolean flag = true;
        for (char ch : s.toCharArray()) {
            if (ch != c) {
                cou++;
                c = ch;
            }
            if (cou <= id) {
                ans[cou]++;
                chars[cou] = ch;
            } else {
                ans[id - (cou - id)]++;
                if (chars[id - (cou - id)] != ch) {
                    pw.println(0);
                    return;
                }
            }
        }
        for (int i = 1; i < id; i++) {
            if (ans[i] < 3) flag = false;
        }
        flag &= !(ans[id] < 2);
        if (flag) {
            pw.println(ans[id]+1);
        } else {
            pw.println(0);
        }
    }
}
