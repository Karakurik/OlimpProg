import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A {
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
        int n = nextInt();
        int m = nextInt();
        int q = nextInt();
        DataCenter[] dataCenters = new DataCenter[n+1];
        TreeSet<DataCenter> dataCentersMin = new TreeSet<>(new Comparator<DataCenter>() {
            @Override
            public int compare(DataCenter o1, DataCenter o2) {
                if (o1.r * o1.enabled == o2.r * o2.enabled) return o1.number - o2.number;
                return o1.r * o1.enabled - o2.r * o2.enabled;
            }
        });
        TreeSet<DataCenter> dataCentersMax = new TreeSet<>(new Comparator<DataCenter>() {
            @Override
            public int compare(DataCenter o1, DataCenter o2) {
                if (o1.r * o1.enabled == o2.r * o2.enabled) return o1.number - o2.number;
                return - o1.r * o1.enabled + o2.r * o2.enabled;
            }
        });
        for (int i = 1; i <=n ; i++) {
            DataCenter dataCenter = new DataCenter(i, m);
            dataCenters[i] = dataCenter;
            dataCentersMin.add(dataCenter);
            dataCentersMax.add(dataCenter);
        }
        for (int i = 0; i < q; i++) {
            switch (nextToken()) {
                case "DISABLE":
                    int t = nextInt();
                    dataCentersMin.remove(dataCenters[t]);
                    dataCentersMax.remove(dataCenters[t]);
                    dataCenters[t].disable(nextInt());
                    dataCentersMin.add(dataCenters[t]);
                    dataCentersMax.add(dataCenters[t]);
                    break;

                case "RESET":
                    t = nextInt();
                    dataCentersMin.remove(dataCenters[t]);
                    dataCentersMax.remove(dataCenters[t]);
                    dataCenters[t].reset();
                    dataCentersMin.add(dataCenters[t]);
                    dataCentersMax.add(dataCenters[t]);
                    break;
                case "GETMAX":
                    pw.println(dataCentersMax.first().number);
                    break;
                case "GETMIN":
                    pw.println(dataCentersMin.first().number);
                    break;
            }
        }

    }

    static class DataCenter {
        int r;
        int number;
        int enabled;
        HashSet<Integer> disabled;

        public DataCenter(int number, int enabled) {
            this.r = 0;
            this.number = number;
            this.enabled = enabled;
            this.disabled = new HashSet<>();
        }

        public void disable(int x) {
            if (!disabled.contains(x)) {
                enabled--;
                disabled.add(x);
            }
        }

        public void reset() {
            r++;
            enabled += disabled.size();
            disabled.clear();
        }


    }
}
