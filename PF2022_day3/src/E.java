import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class E {
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        Map<Integer, Integer> akk = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        int cou = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                add(akk, arr[i]);
            }
            if (arr[i] == 0) cou++;
            if (arr[i] < 0) {
                if (akk.containsKey(-arr[i])) {
                    remove(akk, -arr[i]);
                } else if (cou > 0) {
                    cou--;
                    answer.add(-arr[i]);
                } else {
                    pw.println("No");
                    return;
                }
            }
        }
        for (int i = 0; i < cou; i++) {
            answer.add(1);
        }
        pw.println("Yes");
        for (var d: answer) {
            pw.print(d + " ");
        }
        pw.println();
    }

    private static void remove(Map<Integer, Integer> akk, int i) {
        akk.put(i, akk.get(i) - 1);
        if (akk.get(i) == 0) akk.remove(i);
    }

    private static void add(Map<Integer, Integer> akk, int i) {
        if (!akk.containsKey(i)) akk.put(i, 0);
        akk.put(i, akk.get(i) + 1);
    }
}
