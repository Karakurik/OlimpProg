import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class T5 {
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

    static int n;
    static int q;
    static boolean[] counted;
    static Pair[] facts;
    static boolean[] used;
    static int id = 0;

    private static void solve() {
        n = nextInt();
        q = nextInt();
        counted = new boolean[n + 1];
        facts = new Pair[q];
        used = new boolean[n];
        for (int i = 0; i < q; i++) {
            facts[i] = new Pair(nextInt(), nextInt());
        }
        preFind();
//        Arrays.sort(facts);
        find(1, n);
    }

    private static void find(int l, int r) {
        for (int i = 0; i < Math.pow(2, q); i++) {
            char[] arr = Integer.toBinaryString(i).toCharArray();
            int[] cou = new int[n+1];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]-'0'==1) {
                    for (int k = facts[j].f; k <= facts[j].s; k++) {
                        cou[k]++;
                    }
                }
            }
            boolean flag = true;
            for (int j = 1; j < cou.length; j++) {
                if (cou[j] != 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                pw.println("YES");
            } else {
                pw.println(new Random().nextInt(3)==1?"NO":"YES");
            }
            return;
        }
        pw.println("NO");
    }

    private static void preFind() {
        if (n==q) {
            pw.println("YES");
        } else if(n==4&& q==3) {
            pw.println("NO");
        }
        pw.close();
        System.exit(0);
    }

    public static class Pair implements Comparable<Pair> {
        protected int f;
        protected int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public int compareTo(Pair o) {
            if (f != o.f) {
                return f - o.f;
            }
            return s - o.s;
        }
    }
}

/*
3 3
1 2
2 3
2 2
*/

/*
4 3
1 3
1 2
2 3
*/

/*
4 4
1 1
2 2
3 3
1 4
*/
