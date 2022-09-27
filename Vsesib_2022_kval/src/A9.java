import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A9 {
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        String[] arr = nextLine().split(" ");
        long a = Long.parseLong(arr[0]);
        long b = Long.parseLong(arr[2]);
        long c = Long.parseLong(arr[4]);
        if (arr[1].equals("+")) {
            if (a + b == c) {
                pw.println("correct");
            } else {
                pw.println("incorrect");
                pw.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + (a+b));
            }
        }
        else if (arr[1].equals("-")) {
            if (a - b == c) {
                pw.println("correct");
            } else {
                pw.println("incorrect");
                pw.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + (a-b));
            }
        }
        else if (arr[1].equals("*")) {
            if (a * b == c) {
                pw.println("correct");
            } else {
                pw.println("incorrect");
                pw.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + (a*b));
            }
        }
    }
}
