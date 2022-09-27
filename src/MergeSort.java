import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class MergeSort {
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

    static Random random = new Random();
    private static final int E = 100;

    private static int randomInt() {
        return random.nextInt(E) - E / 2;
    }

    private static void solve() {
        int n = 15;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = randomInt();
        }
        pw.println(Arrays.toString(arr));
        mergeSort(arr, 0, n - 1);
        pw.println(Arrays.toString(arr));
    }
    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) return;
        mergeSort(arr, l, (r + l) / 2);
        mergeSort(arr, (r + l) / 2 + 1, r);
        int[] temp = new int[r - l + 1];
        int cur1 = l;
        int cur2 = (r + l) / 2 + 1;
        for (int i = 0; i < temp.length; i++) {
            if (cur1 > (r + l) / 2) {
                temp[i] = arr[cur2++];
                continue;
            }
            if (cur2 > r) {
                temp[i] = arr[cur1++];
                continue;
            }
            if (arr[cur1] < arr[cur2]) {
                temp[i] = arr[cur1++];
            } else {
                temp[i] = arr[cur2++];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }
}
