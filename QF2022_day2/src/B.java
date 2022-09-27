import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        boolean[][] arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) == '.';
            }
        }
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = -1;
            for (int j = 0; j < m; j++) {
                if (arr[i][j]) {
                    if (l == -1) {
                        l = j;
                    }
                } else {
                    if (l != -1) {
                        list.add(new Pair(new Point(i, l), new Point(i, j - 1), i, -1, j - l));
                        l = -1;
                    }
                }
            }
            if (arr[i][m - 1]) {
                list.add(new Pair(new Point(i, l), new Point(i, m - 1), i, -1, m - l));
            }
        }

        for (int i = 0; i < m; i++) {
            int l = -1;
            for (int j = 0; j < n; j++) {
                if (arr[j][i]) {
                    if (l == -1) {
                        l = j;
                    }
                } else {
                    if (l != -1) {
                        list.add(new Pair(new Point(l, i), new Point(j - 1, i), -1, i, j - l));
                        l = -1;
                    }
                }
            }
            if (arr[n - 1][i]) {
                list.add(new Pair(new Point(l, i), new Point(n - 1, i), -1, i, n - l));
            }
        }
        int answer = 0;
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.len - o1.len;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).len + list.get(j).len < answer) break;
                answer = Math.max(calc(list.get(i), list.get(j)), answer);
            }
        }

        pw.println(answer);
    }

    private static int calc(Pair pair1, Pair pair2) {
        if (pair1.x >= 0 && pair2.x >= 0) return pair1.len + pair2.len;
        if (pair1.y >= 0 && pair2.y >= 0) return pair1.len + pair2.len;

        if (pair1.x < 0) {
            Pair t = pair1;
            pair1 = pair2;
            pair2 = t;
        }

        if (pair1.p1.y <= pair2.y && pair1.p2.y >= pair2.y
                && pair2.p1.x <= pair1.x && pair2.p2.x >= pair1.x
        ) {
            int x = pair1.x;
            int y = pair2.y;
            return Math.max(pair1.len + Math.max(x - pair2.p1.x, pair2.p2.x - x),
                    pair2.len + Math.max(y - pair1.p1.y, pair1.p2.y - y)
                    );
        } else {
            return pair1.len + pair2.len;
        }
    }

    static class Pair {
        Point p1;
        Point p2;

        int x;
        int y;
        int len;

        public Pair(Point p1, Point p2, int x, int y, int len) {
            this.p1 = p1;
            this.p2 = p2;
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
