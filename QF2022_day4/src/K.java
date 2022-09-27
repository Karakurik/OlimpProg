import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class K {
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
        n = nextInt();
        m = nextInt();
        arr = new ArrayList[n];
        used = new boolean[n];
        answer = new Answer(Integer.MIN_VALUE, new ArrayList<>());
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            int c = nextInt();
            arr[a].add(new V(b, c));
            arr[b].add(new V(a, c));
        }
        Queue<V> queue = new LinkedList<>();
        for (var next : arr[0]) {
            if (!used[next.next]) {
                used[next.next] = true;
                queue.add(next);
            }
        }
        used[0] = true;
        ansLength = bfs(queue, 0);
        Arrays.fill(used, false);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        used[0] = true;
        dfs(0, 1, Integer.MAX_VALUE, Integer.MIN_VALUE, list);
        pw.println(answer.list.size());
        for (var x : answer.list) {
            pw.print((x + 1) + " ");
        }
        pw.println(n);
    }

    static Answer answer;
    static int n;
    static int ansLength;
    static int m;
    static boolean used[];
    static List<V>[] arr;

    public static void dfs(int node, int len, int min, int max, List<Integer> list) {
        if (len == ansLength) {
            for (var next : arr[node]) {
                if (next.next == n - 1) {
                    update(new Answer(max - min, list));
                    return;
                }
            }
        }

        if (len == ansLength) return;

        for (var next : arr[node]) {
            used[next.next] = true;
            list.add(next.next);
            dfs(next.next, len + 1, Math.min(min, next.c), Math.max(max, next.c), list);
            list.remove(list.size() - 1);
            used[next.next] = false;
        }
    }

    public static int bfs(Queue<V> queue, int step) {
        Queue<V> newQueue = new LinkedList<>();
        for (var node : queue) {
            if (node.next == n - 1) return step + 1;
            for (var next : arr[node.next]) {
                if (!used[next.next]) {
                    used[next.next] = true;
                    newQueue.add(next);
                }
            }
        }
        return bfs(newQueue, step + 1);
    }

    public static class V {
        Integer next;
        int c;

        public V(Integer next, int c) {
            this.next = next;
            this.c = c;
        }
    }

    static class Answer {
        int maxmin;
        List<Integer> list;

        public Answer(int maxmin, List<Integer> list) {
            this.maxmin = maxmin;
            this.list = new ArrayList<>();
            for (var el : list) {
                this.list.add(el);
            }
        }
    }

    public static void update(Answer cand) {
        if (cand.maxmin > answer.maxmin) {
            answer = cand;
        }
    }
}
