import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

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
        int[] arr = new int[5];
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            switch (s.charAt(0)) {
                case 'B':
                    arr[1]++;
                    break;
                case 'W':
                    arr[2]++;
                    break;
                case '?':
                    l++;
                    break;
            }
            switch (s.charAt(1)) {
                case 'B':
                    arr[3]++;
                    break;
                case 'W':
                    arr[4]++;
                    break;
                case '?':
                    r++;
                    break;
            }
        }
        int k1=0;
        int k2=0;
        if (arr[1] - arr[4] > 0) {
            k2 += arr[1] - arr[4];
        } else {
            k1 += arr[4] - arr[1];
        }

        if (arr[3] - arr[2] > 0) {
            k2 += arr[3] - arr[2];
        } else {
            k1 += arr[2] - arr[3];
        }

        if ((l-k1)%2!=0 || (r-k2)%2!=0) {
            k1++;
            k2++;
        }
        l = k1 + (l-k1)/2;
        r = k2 + (r-k2)/2;
        int ans = fact(l) + fact(r);
        pw.println(ans);
    }

    private static int fact(int r) {
        if (r == 0) return 0;
        int ans = 1;
        for (int i = 2; i <= r; i++) {
            ans *= i;
        }
        return ans;
    }

}