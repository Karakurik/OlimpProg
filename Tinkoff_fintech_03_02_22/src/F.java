import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class F {
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
        List<Integer> list = new ArrayList<>();
        Integer o;
        for (int i = 0; i < n; i++) {
            String[] com = nextLine().split(" ");
            switch (com[0].charAt(0)) {
                case 'A':
                    o = Integer.parseInt(com[1]);
                    list.add(o);
                    break;
                case 'D':
                    o = Integer.parseInt(com[1]);
                    list.remove(o);
                    break;
                case 'Q':
                    Collections.sort(list);
                    if (list.size() % 2 == 1 || list.size() == 0) {
                        pw.println(-1);
                    } else {
                        int id = list.size() / 2;
                        if (list.get(id) == list.get(id - 1)) {
                            pw.println(-1);
                        } else {
                            pw.println(list.get(id) - 1);
                        }
                    }
            }
        }
    }
}