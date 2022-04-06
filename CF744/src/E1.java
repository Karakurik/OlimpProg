import java.io.*;
import java.util.*;

public class E1 {
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
        int t = nextInt();
        while (t-- > 0) {

            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            if (deque.size() == 0 || deque.peek()>=t) {
                deque.addFirst(t);
            } else {
                deque.addLast(t);
            }
        }
        for (Integer i: deque) {
            pw.print(i +" ");
        }
        pw.println();
    }
}