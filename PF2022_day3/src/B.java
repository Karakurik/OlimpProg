import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(nextInt());
        }
        int w = nextInt();
        int h = nextInt();

        int[][] case1 = new int[5][3];
        int[][] case2 = new int[5][3];
        case1[0][0] = 2;
        case1[0][1] = 0;
        case1[0][2] = 2;
        case2[0][0] = 0;
        case2[0][1] = 1;
        case2[0][2] = 2;

        case1[1][0] = 2;
        case1[1][1] = 0;
        case1[1][2] = 2;
        case2[1][0] = 1;
        case2[1][1] = 1;
        case2[1][2] = 1;

        case1[2][0] = 0;
        case1[2][1] = 1;
        case1[2][2] = 2;
        case2[2][0] = 2;
        case2[2][1] = 1;
        case2[2][2] = 1;

        case1[3][0] = 1;
        case1[3][1] = 1;
        case1[3][2] = 1;
        case2[3][0] = 1;
        case2[3][1] = 1;
        case2[3][2] = 2;

        case1[4][0] = 1;
        case1[4][1] = 0;
        case1[4][2] = 1;
        case2[4][0] = 1;
        case2[4][1] = 3;
        case2[4][2] = 1;

        for (int k = 0; k < 100000; k++) {
            Collections.shuffle(arr);
            for (int cas = 0; cas < 5; cas++) {
                int loc1 = 0;
                int loc2 = 0;
                for (int i = 0; i < 3; i++) {
                    loc1 += case1[cas][i] * arr.get(i);
                    loc2 += case2[cas][i] * arr.get(i);
                }
                if (loc1 <= h && loc2 <= w || loc1 <= w && loc2 <= h) {
                    pw.println("Yes");
                    return;
                }
            }
        }

        pw.println("No");
    }
}
