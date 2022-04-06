import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class I {
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

//        int t = nextInt();
//        while (t-- > 0) {
//            solve();
//        }
        solve();
        pw.close();
    }

    static String[] arr;
    static String str;
    static int id;
    static int ans = -1;

    private static void solve() {
        int n = nextInt();
        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLine();
        }
        str = nextLine();
        int[][] lin = new int[n][2];

        int id = 0;
        for (String s : arr) {
            int r = -1, l = -1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == str.charAt(i)) {
                    if (r == -1) {
                        r = i;
                        l = i;
                    } else {
                        l = i;
                    }
                } else {
                    break;
                }
            }
            lin[id][0] = l;
            lin[id][1] = r;
            id++;
        }

        Arrays.sort(lin, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        id = 0;
        int cou = 0;
        int l = 0;
        int r = -1;
        boolean flag = false;
        for (int i = 0; i < lin.length && l < str.length(); i++) {
            if (lin[i][0] == -1) continue;
            if (lin[i][0] <= l) {
                r = Math.max(r, lin[i][1]);
                flag = true;
                if (r==str.length()-1) {
                    cou++;
                    break;
                }
            } else if (flag) {
                flag = false;
                i--;
                l = r+1;
                cou++;
            }
        }
        if (r==str.length()-1) {
            pw.println(cou);
        } else {
            pw.println(-1);
        }
    }

    private static void rec(int id, int cou) {
        for (String s : arr) {
            if (s.length() > id) {
                boolean flag = true;
                for (int i = id; i < s.length(); i++) {
                    if (str.charAt(i) != s.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    if (s.length() == str.length()) {
                        if (ans == -1) {
                            ans = cou + 1;
                        } else {
                            ans = Math.min(ans, cou + 1);
                        }
                    } else {
                        rec(s.length(), cou + 1);
                    }
                }
            }
        }
    }
}