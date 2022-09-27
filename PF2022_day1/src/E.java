import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = nextInt();
            }
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            answerList.add(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int[][] temp = new int[m][3];
            for (int j = 0; j < m; j++) {
                temp[j][0] = arr[j][i];
                temp[j][1] = arr[j][n-1];
                temp[j][2] = j;
            }
            Arrays.sort(temp, (o1, o2) -> (o2[0] - o2[1]) - (o1[0]- o1[1]));
            List<Integer> localAnswerList = new ArrayList<>();
            int t = 0;
            for (int j = 0; j < m; j++) {
                if (temp[j][0] - temp[j][1] + t >= 0) {
                    t += temp[j][0] - temp[j][1];
                } else {
                    localAnswerList.add(temp[j][2]);
                }
            }

            if (localAnswerList.size() < answerList.size()) {
                answerList = localAnswerList;
            }
        }
        pw.println(answerList.size());
        for (Integer i: answerList) {
            pw.print((i+1) + " ");
        }
    }
}
