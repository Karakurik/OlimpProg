import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class F {
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
        int n = nextInt();
        LocalTime[][] arr = new LocalTime[n][2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            String[] s = nextLine().split("-");
            try {
                arr[i][0] = LocalTime.parse(s[0]);
                arr[i][1] = LocalTime.parse(s[1]);
                if (arr[i][0].isAfter(arr[i][1])) {
                    flag = true;
                }
            } catch (Exception e) {
                flag = true;
            }
        }
        if (flag) {
            pw.println("NO");
            return;
        }

        Arrays.sort(arr, Comparator.comparing(o -> o[0]));

        for (int i = 1; i < n; i++) {
            if (!arr[i-1][1].isBefore(arr[i][0])) {
                pw.println("NO");
                return;
            }
        }
        pw.println("YES");
    }
}
