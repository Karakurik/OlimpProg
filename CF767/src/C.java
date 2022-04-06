import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class C {
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
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = 1;
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static int[] mexArr = new int[200001];

    private static void solve() {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
            mexArr[arr[i]]++;
        }
        int l = 0;
        List<Integer> ans = new ArrayList<>();
        while (l < n) {
            int mex = findMex();
            if (mex == 0) {
                ans.add(0);
                mexArr[arr[l]]--;
                l++;
                continue;
            }
            Set<Integer> set = new HashSet<>();
            while (set.size() < mex && l < n) {
                if (arr[l] < mex) {
                    set.add(arr[l]);
                }
                mexArr[arr[l]]--;
                l++;
            }
            if (set.size() == mex) {
                ans.add(mex);
            }
        }
        pw.println(ans.size());
        for (Integer i : ans) {
            pw.print(i + " ");
        }
        pw.println();
    }

    private static int findMex() {
        for (int i = 0; i < mexArr.length; i++) {
            if (mexArr[i] <= 0) return i;
        }
        return 0;
    }
}
