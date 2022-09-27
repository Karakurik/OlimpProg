import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class A8 {
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

        for (int i = 0; i < 31; i++) {
            arr[i] = new ArrayList<>();
        }

        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            arr[t].add(i);
        }

        for (int i = 0; i < 31; i++) {
            Collections.sort(arr[i]);
        }

        int t = 1;
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static int n;
    static List<Integer>[] arr = new List[31];

    private static void solve() {
        int l = nextInt();
        int r = nextInt();
        long m = nextLong();
        int ans = 0;
        StringBuilder bits = new StringBuilder();
        while (m > 0) {
            if (m % 2 != 0) {
                bits.append("1");
            } else {
                bits.append("0");
            }
            m /= 2;
        }
        for (int bit = 0; bit < bits.length(); bit++) {
            if (bits.charAt(bit) != '0') {
                List<Integer> list = arr[bit];
//                for (int el:list) {
//                    if (el >=l && el < r) {
//                        ans += bit;
//                    }
//                }
                int size = list.size();
                int lIndex = 0;
                int rIndex = size;
                if (!list.isEmpty()) {
                    int left = 0;
                    int right = size - 1;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (list.get(mid) >= l) {
                            lIndex = mid;
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }

                    if (list.get(size - 1) < l) {
                        lIndex = size;
                    }
                    if (list.get(0) >= l) {
                        lIndex = 0;
                    }
                    left = 0;
                    right = size - 1;
                    while (left <= right) {
                        int mid = (left + right) / 2;
                        if (list.get(mid) < r) {
                            rIndex = mid + 1;
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    if (list.get(size - 1) < r) {
                        rIndex = size;
                    }
                    if (list.get(0) >=r) {
                        rIndex = 0;
                    }
                    if (lIndex <= rIndex) {
                        ans += (rIndex - lIndex) * bit;
                    }
                }
            }
        }
        pw.println(ans);
    }
}
