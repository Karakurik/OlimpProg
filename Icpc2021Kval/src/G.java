import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class G {
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
//        pw = new PrintWriter(new FileWriter("output.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

//        int t = nextInt();
//        while (t-- > 0) {
//            solve();
//        }

        solve();

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        ArrayList<Integer>[] arr = new ArrayList[100001];
        for (int i = 0; i < 100001; i++) {
            arr[i] = new ArrayList<>();
        }
        int[] val = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            if (x == 1) {
                arr[1].add(x);
                continue;
            }
            if (x <= 100000) {
                arr[x].add(x);
            }
            if (x > max) {
                max = x;
            }
            int Rx = x;
            for (int j = 2; j <= Math.sqrt(Rx); j++) {
                if (x % j == 0) {
                    int cou = 1;
                    x /= j;
                    while (x % j == 0) {
                        cou++;
                        x /= j;
                    }
                    if (x > 1) {
                        continue;
                    }
                    int m = j;
                    arr[m].add(Rx);
                    while (cou % 2 == 0) {
                        m*=2;
                        if (m!=Rx) {
                            arr[m].add(Rx);
                        }
                        cou/=2;
                    }
                }
            }
        }

        for (int i = 1; i < 100001 ; i++) {
            int sum = 0;
            for(int x: arr[i]) {
                sum+=x;
            }
            if (sum>max) {
                max = sum;
            }
        }
        pw.println(max);
    }
}