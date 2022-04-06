import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class tin2 {
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

    private static void solve() throws IOException {
        int rukzakM = nextInt();
        int rukzak = rukzakM;
        int n = nextInt();
        List<Kamen> listN = new ArrayList<>();
        List<Kamen> listY = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int w = nextInt();
            int c = nextInt();
            char f = nextToken().toCharArray()[0];
            if (f == 'Y') {
                listY.add(new Kamen(w, c));
            } else {
                listN.add(new Kamen(w, c));
            }
        }
        listN.sort(Comparator.comparingInt(o -> -o.c / o.w));
        listY.sort(Comparator.comparingInt(o -> -o.c / o.w));
        int nId = 0;
        int yId = 0;
        double sumN = 0.0;
        double ansKand = 0.0;
        int rukzakN = rukzakM;
        while (nId < listN.size() && listN.get(nId).w < rukzakN) {
            sumN += listN.get(nId).c;
            rukzakN -= listN.get(nId).w;
            nId++;
        }
        nId--;
        while (true) {
            rukzak = rukzakN;
            yId=0;
            double sumW = sumN;

            while (rukzak > 0 && yId < listY.size()) {
                if (listY.get(yId).w <= rukzak) {
                    sumW += listY.get(yId).c;
                    rukzak -= listY.get(yId).w;
                    yId++;
                } else {
                    sumW += ((double) listY.get(yId).c)*rukzak/listY.get(yId).w;
                    rukzak = 0;
                }
            }
            if (sumW > ansKand) {
                ansKand = sumW;
                if (nId>=0) {
                    rukzakN += listN.get(nId).w;
                    sumN -= listN.get(nId).c;
                    nId--;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        pw.println(ansKand);
    }

    static class Kamen {
        int w;
        int c;

        public Kamen(int w, int c) {
            this.w = w;
            this.c = c;
        }

        public int getW() {
            return w;
        }

        public void setW(int w) {
            this.w = w;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }
}

/*
150 3
100 100 N
100 100 N
130 10 Y
*/

/*
150 3
100 100 N
100 100 N
100 1000 Y
*/

/*
650 4
207 1459 Y
150 6867 N
694 3494 Y
417 7479 N
*/

/*
3301 7
350 2765 Y
258 560 Y
120 9325 N
879 302 Y
611 2674 Y
774 2273 Y
318 1572 Y
*/



