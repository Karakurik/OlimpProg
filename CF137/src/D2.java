import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringTokenizer st;

    static String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
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

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) {
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        String s = nextLine();
        try {
            s = s.substring(s.indexOf('1'));
        } catch (Exception e) {
            pw.println(0);
            return;
        }
        n = s.length();
        char[] arr = s.toCharArray();
        int id = 0;
        while (id < n && arr[id] == '1') id++;
        if (id == n) {
            pw.println(s);
            return;
        }

        int len = n - id;
        List<String> answers = new ArrayList<>();
        for (int i = 0; i < n - len + 1; i++) {
            char[] ansArr = Arrays.copyOf(arr, arr.length);
            int localId = id;
            for (int j = i; j < i + len; j++) {
                if (arr[j] == '1') ansArr[localId] = '1';
                localId++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(ansArr[j]);
            }
            answers.add(sb.toString());
        }
        String answer = Collections.max(answers);
        int index = answer.indexOf('1');
        if (index >= 0) {
            pw.println(answer.substring(index));
        } else {
            pw.println(0);
        }
    }
}
