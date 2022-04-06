import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

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
        String[] arr = nextLine().split(" ");
        String ans = arr[0];
        Set<String> set = new HashSet<>();
        set.add(arr[0]);
        boolean flag = false;
        for (int i = 1; i < n-2; i++) {
            set.add(arr[i]);
            if (ans.charAt(ans.length()-1)==arr[i].charAt(0)) {
                ans += arr[i].charAt(1);
            } else {
                ans += arr[i];
                flag = true;
            }
        }
        if (flag) {
            pw.println(ans);
            return;
        }
        String s = "a" + arr[0].charAt(0);
        if (!set.contains(s)) {
            pw.println("a" + ans);
            return;
        }
        s = "b" + arr[0].charAt(0);
        if (!set.contains(s)) {
            pw.println("b" + ans);
            return;
        }
        s = arr[arr.length-1].charAt(1) + "b";
        if (!set.contains(s)) {
            pw.println(ans + "b");
            return;
        }
        s = arr[arr.length-1].charAt(1) + "a";
        pw.println(ans + "a");


    }

}