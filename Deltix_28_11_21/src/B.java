import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int t = 1;
        n = nextInt();
        t = nextInt();
        s = nextLine().toCharArray();
        arr = new int[n];
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1];
            if (s[i] == 'c' && s[i - 1] == 'b' && s[i - 2] == 'a') {
                arr[i] = arr[i - 1] + 1;
            }
        }
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static int n;
    static char[] s;
    static int[] arr;

    private static void solve() {
        String str = nextLine();
        int pr = str.indexOf(' ');
        int pos = Integer.parseInt(str.substring(0, pr)) - 1;
        char c = str.charAt(pr + 1);

        int t = 0;
        if (pos >= 2 && s[pos] == 'c' && s[pos - 1] == 'b' && s[pos - 2] == 'a') t++;
        if (pos < n - 2 && s[pos] == 'a' && s[pos + 1] == 'b' && s[pos + 2] == 'c') t++;
        if (pos>=1 && pos <n-1 && s[pos-1]=='a' && s[pos]=='b'&&s[pos+1]=='c') t++;
        s[pos] = c;
        if (pos >= 2 && s[pos] == 'c' && s[pos - 1] == 'b' && s[pos - 2] == 'a') t--;
        if (pos < n - 2 && s[pos] == 'a' && s[pos + 1] == 'b' && s[pos + 2] == 'c') t--;
        if (pos>=1 && pos <n-1 && s[pos-1]=='a' && s[pos]=='b'&&s[pos+1]=='c') t--;
        arr[n-1] -= t;
//        if (c=='c') {
//            if (pos>0 && arr[pos] != arr[pos-1]) {
//                for (int i = pos; i < n; i++) {
//                    arr[i]--;
//                }
//            }
//        } else if (c=='b') {
//
//        }


        pw.println(arr[n - 1]);
        pw.flush();
    }
}