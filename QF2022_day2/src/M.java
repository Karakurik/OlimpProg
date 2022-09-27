import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class M {
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
        pw = new PrintWriter(System.out, true);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int SIZE = n + 1;
        int[] zapas = new int[SIZE];
        for (int i = 0; i < n; i++) {
            zapas[i] = nextInt();
        }
        List<Integer> list = new ArrayList<>();
        while (zapas[0] > 0) {
            for (int i = 0; i < SIZE; i++) {
                if (zapas[i] == 0) {
                    list.add(i - 1);
                    break;
                } else {
                    zapas[i]--;
                }
            }
        }
        Collections.reverse(list);
        int sum = 0;
        for (Integer i : list) {
            sum += i + 1;
        }
        pw.println(sum);
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            if (nextInt() == 1) {
                int t = nextInt();
                zapas[t]++;
                int index = Collections.binarySearch(list, t - 1);
                if (index < 0 && t == 0) {
                    list.add(0, -1);
                    index = 0;
                }
                if (index < 0) index = -index - 1;
                while (index + 1 < list.size() && list.get(index + 1) == t - 1) index++;
                while (index - 1 > 0 && list.get(index) > t - 1) index--;
                if (list.get(index) == t - 1) {
                    int sumDiff = 0;
                    for (int j = t; j < SIZE; j++) {
                        if (zapas[j] != 0) {
                            list.set(index, list.get(index) + 1);
                            sumDiff++;
                            zapas[j]--;
                        } else {
                            break;
                        }
                    }
                    sum += sumDiff;
                }
            } else {
                int t = nextInt();
                int sumDiff = 0;
                if (list.get(list.size() - 1) < t) {
                    zapas[t]--;
                } else {
                    int index = Collections.binarySearch(list, t);
                    if (index < 0) index = -index - 1;
                    while (index + 1 < list.size() && list.get(index) < t) index++;
                    while (index - 1 >= 0 && list.get(index - 1) >= t) index--;
                    for (int j = t; j <= list.get(index); j++) {
                        sumDiff--;
                        zapas[j]++;
                    }
                    list.set(index, t - 1);
                }
                sum += sumDiff;
            }
            pw.println(sum);
        }
    }
}
