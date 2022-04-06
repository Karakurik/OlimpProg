import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C {
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
        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }

        int min1 = -1;
        int min2 = -1;

        Set<Integer> list1 = new TreeSet<>();
        Set<Integer> list2 = new TreeSet<>();
        for (int i = 1; i <= Math.sqrt(arr[0]) + 1; i++) {
            if (arr[0] % i == 0) {
                list1.add(i);
                list1.add((int) (arr[0] / i));
            }
        }
        for (int i = 1; i <= Math.sqrt(arr[1]) + 1; i++) {
            if (arr[1] % i == 0) {
                list2.add(i);
                list2.add((int) (arr[1] / i));
            }
        }
        Set<Integer> del = new TreeSet<>();
        if (!list1.isEmpty()) {
            for (Integer i : list1) {
                if (list2.contains(i)) {
                    del.add(i);
                }
            }
        }
        del.add(1);
        for (Integer i : del) {
            list1.remove((Object) i);
            list2.remove((Object) i);
        }
        if (list1.equals(list2)) {
            pw.println(0);
            return;
        }
        for (int i = 2; i < n; i += 2) {
            del.clear();
            for (Integer i1 : list1) {
                if (arr[i] % i1 != 0) {
                    del.add(i1);
                }
            }
            for (Integer i1 : del) {
                list1.remove(i1);
            }
            del.clear();
            for (Integer i1 : list2) {
                if (arr[i] % i1 == 0) {
                    del.add(i1);
                }
            }
            for (Integer i1 : del) {
                list2.remove(i1);
            }
            if (i + 1 >= n) {
                break;
            }
            del.clear();
            for (Integer i1 : list2) {
                if (arr[i + 1] % i1 != 0) {
                    del.add(i1);
                }
            }
            for (Integer i1 : del) {
                list2.remove(i1);
            }
            del.clear();
            for (Integer i1 : list1) {
                if (arr[i + 1] % i1 == 0) {
                    del.add(i1);
                }
            }
            for (Integer i1 : del) {
                list1.remove(i1);
            }
            if (list1.equals(list2)) {
                pw.println(0);
                return;
            }
        }
        if (list1.equals(list2)) {
            pw.println(0);
        } else {
            if (!list1.isEmpty()) {
                pw.println(list1.iterator().next());
            } else {
                pw.println(list2.iterator().next());
            }
        }
    }
}
