import java.io.*;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class A {
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

    private static HashSet<Integer>[] graph;
    private static void solve() {
        int n = nextInt();
//        char[] ABC = "abcdefghigklmopqrstuvwxyz".toCharArray();
        graph = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new HashSet<>();
        }
        String str1 = nextLine();
        int head = str1.charAt(0)-'a';
        String str2;
        for (int i = 1; i < n; i++) {
            str2 = nextLine();
            int id = 0;
            while (str1.length() > id && str1.charAt(id) == str2.charAt(id)) id++;
            if (str1.length() > id && str2.length() > id) {
                graph[str1.charAt(id)-'a'].add(str2.charAt(id)-'a');
            }
            str1 = str2;
        }

        used = new int[26];
        dfs(head);
        StringBuilder answer = new StringBuilder("");
        while (!stack.isEmpty()) {
            answer.append((char)(stack.pop()+'a'));
        }
        for (int i = 0; i < 26; i++) {
            if (used[i] == 0) {
                answer.append((char)(i+'a'));
            }
        }
        if (flag) {
            pw.println("Impossible");
        } else {
            pw.println(answer.toString());
        }
    }
    private static Stack<Integer> stack = new Stack<>();
    private static int used[];
    private static boolean flag;

    private static void dfs(int i) {
        if (used[i] == 1) {
            flag = true;
        }
        if (used[i] == 0) {
            used[i] = 1;

            for (int t: graph[i]) {
                dfs(t);
            }
            used[i] = 2;
            stack.push(i);
        }
    }
}