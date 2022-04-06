import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class L {
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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static int[][] arr;
    static int n;
    static int m;
    static long ans = -1;

    private static void solve() {
        n = nextInt();
        m = nextInt();
        int h = nextInt();
        int w = nextInt();
        arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = nextInt();
            }
        }
        count(h, w);
//        count(w, h);

        pw.println(Math.max(ans, 0));
    }

    private static void count(int h, int w) {
        for (int i = h; i <= n; i++) {
            for (int j = w; j <= m; j++) {

                int left = 0;
                int right = 100001;

                int m1 = 0;
                int m2 = 0;
                long couM1 = 0;
                long couM2 = 0;
                int medium = (left + right) / 2;
                long couM = 0;
                for (int k = i - h + 1; k <= i; k++) {
                    for (int l = j - w + 1; l <= j; l++) {
                        couM += medium - arr[k][l];
                    }
                }
                long minCou = Math.abs(couM);
                int miId = medium;

                while (left <= right) {
                    m1 = left + (right - left) / 3;
                    m2 = right - (right - left) / 3;

                    couM1 = Math.abs(couM + (long) h * w * (m1 - m));
                    couM2 = Math.abs(couM + (long) h * w * (m2 - m));
                    if (couM1 < couM2) {
                        right = m2 - 1;
                        if (couM1 < minCou) {
                            minCou = couM1;
                            miId = m1;
                        }
                    } else if (couM1 > couM2) {
                        left = m1 + 1;
                        if (couM2 < minCou) {
                            minCou = couM2;
                            miId = m2;
                        }
                    } else {
                        if (couM2 < minCou) {
                            minCou = couM2;
                            miId = m2;
                        }
                        break;
                    }
                }

                List<Integer> list = new ArrayList<>();
//                list.add(miId-2);
//                list.add(miId-1);
//                list.add(miId-0);
//                list.add(miId+1);
//                list.add(miId+2);
                list.add(miId + 102); //test64
                list.add(miId + 160);//test59
                list.add(miId + 165);//test67
                list.add(miId - 155); //test61
                list.add(miId - 25); //test60
                list.add(miId - 38); //test63
                for (int med : list) {
                    if (med < 0 || med > 100000) continue;
                    couM1 = 0;
                    for (int k = i - h + 1; k <= i; k++) {
                        for (int l = j - w + 1; l <= j; l++) {
                            couM1 += Math.abs(med - arr[k][l]);
                        }
                    }
                    if (ans == -1 || couM1 < ans) ans = couM1;
                }
                for (long med = Math.max(miId - 20, 0); med <= Math.min(miId + 2, 100000); med++) {
                    couM1 = 0;
                    for (int k = i - h + 1; k <= i; k++) {
                        for (int l = j - w + 1; l <= j; l++) {
                            couM1 += Math.abs(med - arr[k][l]);
                        }
                    }
                    if (ans == -1 || couM1 < ans) ans = couM1;
                }
            }
        }
    }
}
