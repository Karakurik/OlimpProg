import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    static List<Long> F1;
    static List<Long> F2;

    private static void solve() {
        F1 = new ArrayList<>();
        F2 = new ArrayList<>();

        int n = nextInt();
        int m = nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = nextInt();
        }
        long a = (long) (Math.pow(2, n) - 1);
        while (a > 0) {
            long a1 = a;
            int i = 0;
            long sum = 0;
            while (a1 > 0) {
                sum += arr1[i] * (a1 % 2);
                i++;
                a1 /= 2;
            }
            F1.add(sum);
            a--;
        }
        a = (long) (Math.pow(2, m) - 1);
        while (a > 0) {
            long a1 = a;
            int i = 0;
            long sum = 0;
            while (a1 > 0) {
                sum += arr2[i++] * (a1 % 2);
                a1 /= 2;
            }
            F2.add(sum);
            a--;
        }
        int answer = 0;
        for(Long l1:F1) {
            for(Long l2:F2) {
                if (l1.equals(l2)) {
                    answer++;
                }
            }
        }
        pw.println(answer);
    }
}