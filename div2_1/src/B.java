import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
//        pw = new PrintWriter(new FileWriter("output.txt"));
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }


    private static boolean[] used;
    private static int[] countColor;
    private static int cou;
    private static int[] colors;
    private static TreeSet<Integer>[] graph;

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = nextInt()-1;
        }
        graph = new TreeSet[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new TreeSet<>();
        }

        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            if (a > b) {
                int c = a;
                a = b;
                b = c;
            }
            graph[a].add(b);
        }

        used = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 0) continue;
            countColor = new int[k];
            cou = 0;
            dfc(i);
            answer += cou - maxColor();
        }

        System.out.println(answer);
    }

    private static int maxColor() {
        int ans = 0;
        for (int i : countColor) {
            if (i > ans) {
                ans = i;
            }
        }
        return ans;
    }

    private static void dfc(int i) {
        if (!used[i] ) {
            used[i] = true;
            cou++;
            countColor[colors[i]]++;
            for (int j : graph[i]) {
                dfc(j);
            }
        }
    }
}