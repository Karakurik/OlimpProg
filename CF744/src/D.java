import java.io.*;
import java.util.*;

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
        int[][] arr = new int[n+1][2];
        for (int i = 0; i < n; i++) {
            arr[i+1][0] = nextInt();
            arr[i+1][1] = i+1;
        }
        Arrays.sort(arr, (o1, o2) -> o2[0]-o1[0]);
        List<String> answerList = new ArrayList<>();
        while (arr[1][0] != 0) {
            while (arr[1][0] > 0 && arr[1][0] >= arr[2][0]) {
                answerList.add(arr[0][1] + " " + arr[1][1]);
                arr[0][0]--;
                arr[1][0]--;
            }
            Arrays.sort(arr, (o1, o2) -> o2[0]-o1[0]);
        }
        pw.println(answerList.size());
        for (String s: answerList
             ) {
            pw.println(s);
        }
    }
}