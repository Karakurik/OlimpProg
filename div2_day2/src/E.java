import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E {
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

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static char nextChar() {
        try {
            return (char)br.read();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static int nexInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        solve();
        pw.close();
    }

    private static void solve() {
        List<Korab> list = new ArrayList<>();
        boolean[] flag = new boolean[11];
        boolean[][] arr = new boolean[12][12];
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                arr[i][j] = nextChar() == 'x';
            }
            if (i!=10) {
                nextChar();
//                nextChar();
            }
        }

        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (arr[i][j]) {
                    if (!arr[i - 1][j] && !arr[i + 1][j]) {
                        y1 = j;
                        arr[i][j] = false;
                        while (arr[i][j+1]) {
                            j++;
                            arr[i][j] = false;
                        }
                        list.add(new Korab(i, y1, i, j));
                    }
                }
            }
        }

        for (int j = 1; j < 11; j++) {
            for (int i = 1; i < 11; i++) {
                if (arr[i][j]) {
                    if (!arr[i][j-1] && !arr[i][j+1]) {
                        x1 = i;
                        arr[i][j] = false;
                        while (arr[i+1][j]) {
                            i++;
                            arr[i][j] = false;
                        }
                        list.add(new Korab(x1, j, i, j));
                    }
                }
            }
        }
        pw.println(list.size());
        for(Korab k : list) {
            pw.println(k.toString());
        }
    }

    public static class Korab {
        int x1;
        int y1;
        int x2;
        int y2;

        public Korab(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return x1 + " " + y1 + " " + x2 + " " + y2;
        }
    }
}
