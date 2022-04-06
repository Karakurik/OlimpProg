import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class I {
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

    private static ArrayList<Integer>[] graph;
    private static int n;
    private static int parent = 0;


    private static void solve() {
        n = nextInt();
        graph = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            graph[i+1] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int x = nextInt();
            int y = nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        int k = 1;
        countChildren(k);
        if (!flag) {
            pw.println("NO");
        }
    }

    private static int countChildren(int k) {
        if (flag) return 0;
        int cou = 0;
        graph[k].remove((Object)parent);
        parent = k;
        for (int i : graph[k]) {
            cou += countChildren(i);
            parent = k;
        }
        cou++;
        if (cou == n/2) {
            getAns(k);
        }
        return cou;
    }

    private static boolean[] used;
    private static boolean flag = false;
    private static void getAns(int k) {
        if (flag) return;
        used = new boolean[n+1];
        dfs(k);
        flag = true;
        pw.println("YES");
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                pw.print(1 + " ");
            } else {
                pw.print(0 + " ");
            }
        }
        return;
    }

    private static void dfs(int k) {
        used[k] = true;
        parent = k;
        for (int i : graph[k]) {
            dfs(i);
            parent = k;
        }
    }
}