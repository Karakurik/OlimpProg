import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class J {
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

    private static void solve() {
        int E = 1_000_000;
        for (int i = 1; i <= E; i++) {
            for (int j = i; j <= E; j++) {
                if ((long) i * j / 2 > (long) E) break;
                long gip2 = (long) i * i + (long) j * j;
                long gip = Math.round(Math.sqrt(gip2));
                if (gip * gip == gip2) {
                    if (gcd(i, j) == 1) {
                        basic.add(new Triangle(i, j, (int) gip));
                    }
                }
            }
        }
        Collections.sort(basic);
        int n = nextInt();
        int[] arr = new int[E];
        for (int i = 0; i < n; i++) {
            arr[nextInt()]++;
        }
        List<Triangle> newBasic;
        int[] temp = new int[E];
        for (Triangle t : basic) {
            temp[t.gip]++;
            temp[t.bol]++;
            temp[t.mal]++;
        }
        Set<Integer> storons = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (temp[i] == 1) {
                storons.add(i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                storons.add(i);
            }
        }
        for (Integer st : storons) {
            if (st==8) {
                pw.println();
            }
            if (arr[st] > 0) {
                Triangle tr = null;
                int cou = arr[st];
                for (Triangle t : basic) {
                    if ((t.gip == st || t.mal == st || t.bol == st)
                        && (arr[t.gip] >= cou
                            && arr[t.bol] >= cou
                            && arr[t.mal] >= cou)
                    ) {
                        tr = t;
                        break;
                    }
                }
                for (int i = 0; i < cou; i++) {
                    pw.println(tr.toString());
                }
                arr[tr.gip] -= cou;
                arr[tr.bol] -= cou;
                arr[tr.mal] -= cou;
            }
        }
    }

    static List<Triangle> basic = new ArrayList<>();

    static class Triangle implements Comparable<Triangle> {
        int mal;
        int bol;
        int gip;

        public Triangle(int mal, int bol, int gip) {
            this.mal = mal;
            this.bol = bol;
            this.gip = gip;
        }

        @Override
        public int compareTo(Triangle o) {
            if (this.gip > o.gip) return -1;
            if (o.gip > this.gip) return 1;
            return o.bol - this.bol;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triangle triangle)) return false;

            if (mal != triangle.mal) return false;
            if (bol != triangle.bol) return false;
            return gip == triangle.gip;
        }

        @Override
        public int hashCode() {
            int result = mal;
            result = 31 * result + bol;
            result = 31 * result + gip;
            return result;
        }

        @Override
        public String toString() {
            return gip + " " + bol + " " + mal;
        }
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
