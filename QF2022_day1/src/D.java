import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class D {
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

    static Queue<Integer> queue;
    static TreeMap<Integer, Integer> treeMultiSet;
    static int lastMinimum = -1;
    static boolean lastQuestion = false;
    static Queue<Integer> newNumbers;

    private static void solve() {
        int n = nextInt();
        queue = new LinkedList<>();
        newNumbers = new LinkedList<>();
        treeMultiSet = new TreeMap();
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            switch (s.charAt(0)) {
                case '+' -> {
                    int t = Integer.parseInt(s.substring(1));
                    add(t);
                }
                case '-' -> {
                    remove();
                }
                case '?' -> {
                    question();
                }
            }
        }
    }

    private static void add(int t) {
        queue.add(t);
        if (lastQuestion) newNumbers.add(t);
        if (treeMultiSet.containsKey(t)) {
            treeMultiSet.put(t, treeMultiSet.get(t) + 1);
        } else {
            treeMultiSet.put(t, 1);
        }
    }

    private static void remove() {
        int t = queue.poll();
        if (queue.size() < newNumbers.size()) newNumbers.poll();
        if (treeMultiSet.get(t) > 1) {
            treeMultiSet.put(t, treeMultiSet.get(t) - 1);
        } else {
            treeMultiSet.remove(t);
        }
    }

    private static void question() {
        int t = treeMultiSet.firstKey();
        if (t != lastMinimum || !lastQuestion) {
            for (var i : queue) {
                if (i % t != 0) {
                    pw.println("N");
                    lastQuestion = false;
                    newNumbers.clear();
                    lastMinimum = t;
                    return;
                }
            }
            pw.println("Y" + t);
            lastQuestion = true;
            newNumbers.clear();
            lastMinimum = t;
            return;
        }

        if (lastQuestion) {
            for (var i : newNumbers) {
                if (i % t != 0) {
                    pw.println("N");
                    lastQuestion = false;
                    newNumbers.clear();
                    lastMinimum = t;
                    return;
                }
            }
            pw.println("Y" + t);
            lastQuestion = true;
            newNumbers.clear();
            lastMinimum = t;
        }
    }
}
