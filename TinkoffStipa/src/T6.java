import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class T6 {
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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int[] arr = new int[100001];
        for (int i = 0; i < n; i++) {
            arr[nextInt()]++;
        }
        int cou = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) cou+= arr[i]-1;
        }
        pw.println(n - cou - cou%2);
    }
}

/*
5
1 2 5 5 5
*/

/*
5
2 3 2 1 9
*/

/*
8
8 1 3 1 2 3 5 8
*/
