import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
//        int t = nextInt();
//        while (t-- > 0) {
//            solve();
//        }
        solve();
        pw.close();
    }

    private static void solve() {
        int[] arr =new int[16];
        for (int i = 0; i < 15; i++) {
            arr[i+1] = nextInt();
        }
        boolean flag = true;
        if (arr[1]!=1)flag = false;
        if (arr[5]!=8) flag = false;
        int t;
        if (arr[15] >=9 && arr[15]<=15) {
            if (arr[11] >=9 && arr[11]<=15) flag = false;
        } else {
            if (arr[11] >=1 && arr[11]<=7) flag = false;
        }
        if (flag) {
            pw.println("Yes");
        } else {
            pw.println("No");
        }
    }
}