import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class С {
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

    static int m;

    private static void solve() {
        int n = nextInt();
        m = nextInt();

        Node root = new Node('$');
        root.size = 1;
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            Node node = root;
            root.size++;
            for (char c : s.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    Node newNode = new Node(c);
                    node.children.put(c, newNode);
                }
                node = node.children.get(c);
                node.size++;
            }
        }

        pw.println(clear(root));
    }

    private static int clear(Node node) {
        int childrenSize = 0;
        for (var x : node.children.entrySet()) {
            childrenSize += x.getValue().size;
        }
        int flag = node.size - childrenSize;
        if (childrenSize + flag <= m) {
            node.size = 0;
            return 1;
        }
        int ans = 0;
        var list = node.children.entrySet().stream().sorted((o1, o2) -> o2.getValue().size - o1.getValue().size).collect(Collectors.toList());
        while (childrenSize > m) {
            list = node.children.entrySet().stream().sorted((o1, o2) -> o2.getValue().size - o1.getValue().size).collect(Collectors.toList());
            childrenSize -= list.get(0).getValue().size;
            ans += clear(list.get(0).getValue());
            childrenSize += list.get(0).getValue().size;
        }

        if (childrenSize > 0) {
            if (childrenSize + flag <= m) {
                ans++;
                flag = 0;
            } else {
                ans++;
            }
        }

        node.size = flag;

        return ans;
    }

    public static class Node {
        Character c;
        Map<Character, Node> children = new HashMap<>();
        int size = 0;

        public Node(Character c) {
            this.c = c;
        }
    }
}
