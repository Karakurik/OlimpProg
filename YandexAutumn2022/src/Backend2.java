import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Backend2 {
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
        int q = nextInt();
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Node newNode = new Node();
            int t = i / 2;
            if (t >= 1) {
                newNode.parent = map.get(t);
                if (2 * t == i) {
                    map.get(t).left = newNode;
                } else {
                    map.get(t).right = newNode;
                }
            }
        }
        for (int i = 0; i < q; i++) {
            int t = nextInt();
            Node с = map.get(t);
            Node p = с.parent;
            Node pp = p.parent;
            if (pp == null) {

            }
        }
    }

    static class Node {
        Node parent;
        Node left;
        Node right;
    }
}
