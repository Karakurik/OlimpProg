import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
        int n = nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = nextInt();
            }
        }
        List<Integer> days = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int cou = n/2;
            for (int j = 0; j < n; j++) {
                cou -= (int)arr[j][i];
            }
            if (cou == 0) {
                days.add(i);
            }
        }
        if (days.size()<2) {
            pw.println("NO");
        } else {
            for (int i =0; i < days.size(); i++) {
                for (int j = i+1; j < days.size(); j++) {
                    boolean flag = true;
                    for (int k = 0; k < n; k++) {
                        if (arr[k][i]==arr[k][j]) {
                         flag = false;
                        }
                    }
                    if(flag) {
                        pw.println("YES");
                        return;
                    }
                }
            }
            pw.println("NO");
        }

    }
}