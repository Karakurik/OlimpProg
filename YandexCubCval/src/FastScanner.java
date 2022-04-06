import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FastScanner {
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
        solve();
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int s = nextInt();
        int t = nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int[] time = new int[t];
        time[arr[0][0] % t]++;
        arr[0][2] = 1;
        s--;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] != arr[i-1][0]) {
                for (int j = arr[i-1][0]%t+1; j <= arr[i][0]%t + t && j%t!=arr[i][0]%t; j++) {
                    s += time[j%t];
                    time[j%t] = 0;
                }
                s += time[arr[i][0]%t];
                time[arr[i][0]%t] = 0;
            }
            if (s > 0) {
                arr[i][2] = 1;
                s--;
                time[arr[i][0] % t]++;
            }
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < n; i++) {
            pw.println(arr[i][2] == 1?"YES":"NO");
        }
    }
}