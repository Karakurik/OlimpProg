import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
        fibb.add(0);
        fibb.add(1);
        fibbRemove.put(0, 0);
        fibbRemove.put(1, 0);
        int akkum = 0;
        int i = 2;
        while (true) {
            int temp = fibb.get(i - 1) + fibb.get(i - 2);
            if (temp > 1_000_000_000) break;
            fibb.add(temp);
            akkum += Math.max(0, temp - fibb.get(i-1)-1);
            fibbRemove.put(i, akkum);
            i++;
        }
        t = nextInt();
        for (int j = 1; j <= t; j++) {
            pw.printf("Case #%d: ", j);
            solve();
        }

        pw.close();
    }

    static List<Integer> fibb = new ArrayList<>();
    static Map<Integer, Integer> fibbRemove = new HashMap<>();

    private static void solve() {
        int n = nextInt();
        int res = Collections.binarySearch(fibb, n);
        if (res >= 0) {
            pw.println(fibbRemove.get(res));
        } else {
            res = -res - 2;
            pw.println(fibbRemove.get(res) + n - fibb.get(res));
        }
    }
}
