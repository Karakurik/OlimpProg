import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
//        pw = new PrintWriter(new FileWriter("output.txt"));
        pw = new PrintWriter(System.out);
//        int t = nextInt();
//        while (t-- > 0) {
//            solve();
//        }
        solve();
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        class Pair {
            int x;
            int y;

            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Pair pair = (Pair) o;

                if (x != pair.x) return false;
                return y == pair.y;
            }

            @Override
            public int hashCode() {
                int result = x;
                result = 31 * result + y;
                return result;
            }
        }
        boolean t = false;
        boolean b = false;
        boolean l = false;
        boolean r = false;
        int[][] arr = new int[n][4];
        Set<Pair> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x1 = nextInt();
            int y1 = nextInt();
            int x2 = nextInt();
            int y2 = nextInt();

            if (x1==0 ||x2==0) l = true;
            if (x1==10e4 ||x2==10e4) r = true;
            if (y1==0 ||y2==0) b = true;
            if (y1==10e4 ||y2==10e4) t = true;


            arr[i][0] = x1;
            arr[i][1] = y1;
            arr[i][2] = x2;
            arr[i][3] = y2;
            Pair p = new Pair(x1,y1);
            if (set.contains(p)) {
                set.remove(p);
            } else {
                set.add(p);
            }
            p = new Pair(x2,y2);
            if (set.contains(p)) {
                set.remove(p);
            } else {
                set.add(p);
            }
        }
        int tr = 0;
        if (l) tr++;
        if (b) tr++;
        if (t) tr++;
        if (r) tr++;
        if (tr>=2) {
            pw.println("No");
            return;
        }
        if (set.isEmpty()) {
            for (int i = 1; i < n; i++) {
                if ((arr[0][3]-arr[0][1])/(arr[0][2]-arr[0][0])
                != (arr[i][3]-arr[i][1])/(arr[i][2]-arr[i][0])) {
                    pw.println("No");
                    return;
                }
            }
            pw.println("Yes");
        } else {
            pw.println("Yes");
        }

    }
}