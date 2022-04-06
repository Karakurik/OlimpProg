import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;
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
        arr = nextLine().toCharArray();
        k = new int[arr.length+1];
        int kok = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]=='(') {
                stack.add(kok);
                k[i+1] = kok;
                kok++;
            }
            else {
                if (!stack.isEmpty()) {
                    k[i+1] = stack.pop();
                }
            }
        }
        int t = nextInt();
        while (t-- > 0) {
            solve();
        }
//        solve();
        pw.close();
    }

    static char[] arr;
    static int[] k;
    private static void solve() {
        int l = nextInt();
        int r = nextInt();
        int cou =0;
        while (k[l]==0) {
            l++;
            cou++;
            if (l>r) {
                pw.println(cou);
                return;
            }
        }
        while (k[r]==0) {
            r--;
            cou++;
        }
        int lVal = k[l];
        int rVal = k[r];
        if (lVal==rVal) {
            pw.println(cou);
            return;
        }
        int cou1 =r+1, cou2=r+1;
        boolean flag = false;
        for (int i = l+1; i < r; i++) {
            if (k[i] == lVal) {
                cou1 = cou+r-i;
                flag=true;
            }
            if (k[i]==rVal) {
                cou2 = cou + i-l;
                flag=true;
            }
        }
        if (flag) {
            pw.println(Math.min(cou1, cou2));
            return;
        }
        pw.println(cou+r-l+1);
    }
}