import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
    static BufferedReader br;
    static StringTokenizer st;
    static PrintWriter pw;

    static String nextToken () {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static char nextChar() {
        try {
            return (char) br.read();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    static int nexInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);

        solve();
        pw.close();
    }

    private static void solve() {
        int n = nexInt();
        int m = nexInt();
        int[][] arr =new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = (nextChar()-'0' + 1)%2;
            }
            if (i!=n-1) {
                nextChar();
            }
        }
        int[] cou = new int[n];
        boolean flag = true;
        if (arr[0][0]==1) {
            cou[0]=1;
            arr[0][0] = 1;
        } else {
            flag = false;
        }
        for (int i = 1; i < n; i++) {
            if (flag && arr[i][0]==1) {
                arr[i][0]+=arr[i-1][0];
                cou[i] = arr[i][0];
            } else {
                flag = false;
                arr[i][0] = -1;
                cou[i] = -1;
            }
        }
        for (int j = 1; j < m; j++) {
            flag = false;
            for (int i = 0; i < n; i++) {
                int k = cou[i];
                if (k==-1) {
                    continue;
                }
                flag = true;
                if (k > arr[i][j]) {
                    arr[i][j] = k;
                }
                for (int l = i+1; l < n; l++) {
                    if (arr[l][j]==0) break;
                    k += arr[l][j];
                    if (k>arr[l][j]) arr[l][j] = k;
                }
                k = arr[i][j-1];
                for (int l = i-1; l >=0 ; l--) {
                    if (arr[l][j]==0) break;
                    k += arr[l][j];
                    if (k>arr[l][j]) arr[l][j] = k;
                }
            }
            if (!flag) {
                pw.println(-1);
                return;
            }
        }
        pw.println(arr[n-1][m-1]);
    }
}
