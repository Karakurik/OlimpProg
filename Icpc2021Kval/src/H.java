import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {
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
        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = nextInt();
        }
        Arrays.sort(arr);
        if ((arr[2] - arr[1]) % 2 == 0 && !(arr[0]==0&&arr[1]==0)) {
            int t = (arr[2] - arr[1]) / 2;
            arr[1] += t;
            arr[2] -= t;
            arr[0] -= t;
            if ((arr[1] - arr[0]) % 2 == 0) {
                int k = (arr[1] - arr[0]) / 2;
                arr[0]+=k;
                arr[1]-=k;
                arr[2]-=k;
                if (arr[0]>=0) {
                    pw.println(t + k);
                    return;
                }
            }
        }
        pw.println(-1);
    }
}