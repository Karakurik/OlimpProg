import com.sun.org.apache.xpath.internal.operations.Number;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B {
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int k =1;
        while ((1<<k)<=n-1) k++;
        k--;
        for (int i = (1<<k)-1; i >=0 ; i--) {
            pw.print(i + " ");
        }
        for (int i = (1<<k); i < n; i++) {
            pw.print(i + " ");
        }
        pw.println();
        try {
            new Scanner(new File("")).nextLine();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    void fun() {

    }
}
