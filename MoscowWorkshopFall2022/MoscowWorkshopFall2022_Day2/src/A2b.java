import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A2b {
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
        int n = nextInt();
        Tree tree = new Tree();
        for (int i = 1; i <= n; i++) {
            int t = nextInt();
            int m = nextInt();
            if (m == 0) {
                Node p = tree.get(t);
                Node pp = p.parent;
                tree.add(i, pp);
                pp.snegovices.add(i);
            } else {
                Node p = tree.get(t);
                Node child = new Node(p.cost + m, new ArrayList<>(), p);
                child.snegovices.add(i);
                p.children.add(child);
                tree.add(i, child);
            }
        }
        long ans = count(tree.get(0));
        pw.println(ans);
    }

    private static long count(Node node) {
        long ans = (long) node.cost * node.snegovices.size();
        for (Node n: node.children) {
            ans += count(n);
        }
        return ans;
    }

    static class Tree {
        Map<Integer, Node> nodes = new HashMap<>();

        public Tree() {
            nodes.put(0, new Node(0, new ArrayList<>(), null));
            nodes.get(0).snegovices.add(0);
        }

        public Node get(int i) {
            return nodes.get(i);
        }

        public void add(Integer i, Node d) {
            nodes.put(i, d);
        }
    }

    static class Node {
        Node parent;
        List<Node> children;
        int cost;
        List<Integer> snegovices;

        public Node(int cost, List<Integer> snegovices, Node parent) {
            this.cost = cost;
            this.snegovices = snegovices;
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }
}
