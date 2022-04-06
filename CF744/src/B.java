import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
//        pw = new PrintWriter(new FileWriter("output.txt"));
        pw = new PrintWriter(System.out);
        int t = nextInt();
        while (t-- > 0) {

            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        long[] arr = new long[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nextLong();
        }
        long ansCou = 0;
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int index = 0;
            for (int j = i; j <= n; j++) {
                if (index == 0 || arr[j] < arr[index]) {
                    index = j;
                }
            }
            if (index != i) {
                list.add(i + " " + index + " " + (index - i));
            }
            long t = arr[index];
            for (int j = index; j > i; j--) {
                arr[j] = arr[j - 1];
            }
            arr[i] = t;
        }
        pw.println(list.size());
        for (String s : list) {
            pw.println(s);
        }
    }
}