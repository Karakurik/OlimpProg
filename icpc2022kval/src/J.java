import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class J {
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
        String s = nextLine();
        char[] arr = s.toCharArray();
        List<Integer> indexex0 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') indexex0.add(i);
        }
        if (indexex0.size()==0) {
            pw.println(s);
            return;
        }
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < indexex0.get(0); i++) {
            candidates.add(i);
        }
        for (int index0: indexex0) {
            List<Integer> newCandidates = new ArrayList<>();
            for (int candidate: candidates) {
                if (arr[candidate + index0 - indexex0.get(0)] == '1') {
                    newCandidates.add(candidate);
                }
            }
            if (!newCandidates.isEmpty()) {
                candidates = newCandidates;
            }
        }
        char[] answerArray = Arrays.copyOf(arr, arr.length);
        if (!candidates.isEmpty()) {
            int candidate = candidates.get(0);
            for (int index0: indexex0) {
                if (arr[candidate + index0 - indexex0.get(0)] == '1') {
                    answerArray[index0] = '1';
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (char c: answerArray) {
            if (c == '1' || answer.length() > 0) {
                answer.append(c);
            }
        }
        if (answer.length()==0) answer.append(0);
        pw.println(answer);
    }
}
