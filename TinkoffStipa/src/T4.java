import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class T4 {
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
        int V = nextInt();
        int m = nextInt();
        int source = 0;
        int destination = V - 1;
        List<List<Node>> adj = new ArrayList<List<Node>>();

        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int s = nextInt() - 1;
            int d = nextInt() - 1;
            list.add(new Pair(s, d));
            adj.get(s).add(new Node(d, 1));
        }
        for (int i = 0; i < m; i++) {
            Node node = new Node(list.get(i).s, 1);
            adj.get(list.get(i).f).remove(node);
            DPQ dpq = new DPQ(V);
            dpq.dijkstra(adj, source);
            int ans = dpq.dist[destination];
            if (ans< 400*400) {
                pw.println(ans);
            } else {
                pw.println(-1);
            }
            adj.get(list.get(i).f).add(node);
        }
    }

    static class DPQ {
        private int dist[];
        private Set<Integer> settled;
        private PriorityQueue<Node> pq;
        private int V;
        List<List<Node>> adj;

        public DPQ(int V) {
            this.V = V;
            dist = new int[V];
            settled = new HashSet<>();
            pq = new PriorityQueue<>(V, new Node());
        }

        public void dijkstra(List<List<Node>> adj, int src) {
            this.adj = adj;
            for (int i = 0; i < V; i++)
                dist[i] = Integer.MAX_VALUE;
            pq.add(new Node(src, 0));
            dist[src] = 0;
            while (settled.size() != V) {
                if (pq.isEmpty())
                    return;
                int u = pq.remove().node;
                settled.add(u);
                e_Neighbours(u);
            }
        }

        private void e_Neighbours(int u) {
            int edgeDistance = -1;
            int newDistance = -1;
            for (int i = 0; i < adj.get(u).size(); i++) {
                Node v = adj.get(u).get(i);
                if (!settled.contains(v.node)) {
                    edgeDistance = v.cost;
                    newDistance = dist[u] + edgeDistance;
                    if (newDistance < dist[v.node])
                        dist[v.node] = newDistance;
                    pq.add(new Node(v.node, dist[v.node]));
                }
            }
        }

    }

    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node1 = (Node) o;

            if (node != node1.node) return false;
            return cost == node1.cost;
        }

        @Override
        public int hashCode() {
            int result = node;
            result = 31 * result + cost;
            return result;
        }
    }

    static class Pair {
        public int f;
        public int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
}

/*
3 3
1 2
2 3
1 3
*/

/*
5 5
1 2
1 3
2 4
3 4
4 5
*/

/*
4 3
1 2
2 4
3 4
*/


