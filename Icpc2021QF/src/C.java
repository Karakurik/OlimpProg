import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    static List<Integer> listA;
    static List<Integer> listB;
    static int x;
    static int y;

    private static void solve() {
        int n = nextInt();
        int k = nextInt();
        currentX = new ArrayList[k+1];
        for (int i = 0; i <= k; i++) {
            currentX[i] = new ArrayList<>();
        }
        x = nextInt();
        y = nextInt();
        listA = new ArrayList<>();
        listB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = nextLine();
            int t = Integer.parseInt(s.substring(2));
            char c = s.charAt(0);
            if (c == 'A') {
                listA.add(t);
            } else {
                listB.add(t);
            }
        }
        int idA = 0;
        int idB = 0;
        long answer = 0L;
        listA.sort((o1, o2) -> {
            return o2 - o1;
        });
        listB.sort((o1, o2) -> {
            return o2 - o1;
        });

        pw.println(test(k, idA, idB, 0));
    }

    static ArrayList<Long>[] currentX;
    private static long test(int k, int idA, int idB, long currentAns) {
        if (k == 0) return currentAns;
        if (currentX[k].contains(currentAns)) {
            return -1000_000_000_000_000_000L;
        }
        currentX[k].add(currentAns);
        if (idA >= listA.size()) {
            return test(k - 1, idA, idB + 2, listB.get(idB) + listB.get(idB + 1)-y);
        }
        if (idB >= listB.size()) {
            return test(k - 1, idA + 2, idB, listA.get(idA) + listA.get(idA + 1)-x);
        }
        Integer AA = null;
        Integer AB = listA.get(idA) + listB.get(idB);
        Integer BB = null;
        if (idA + 1 < listA.size()) {
            AA = listA.get(idA) + listA.get(idA + 1) - x;
        }
        if (idB + 1 < listB.size()) {
            BB = listB.get(idB) + listB.get(idB + 1) - y;
        }

        if (AA == null && BB == null) {
            return test(k - 1, idA + 1, idB + 1, AB);

        } else if (AA == null) {
            return Math.max(test(k - 1, idA + 1, idB + 1, AB), test(k - 1, idA, idB + 2, BB));
        } else if (BB == null) {
            return Math.max(test(k - 1, idA + 1, idB + 1, AB), test(k - 1, idA + 2, idB, AA));
        } else {
            return Math.max(test(k - 1, idA + 2, idB, AA), Math.max(test(k - 1, idA + 1, idB + 1, AB), test(k - 1, idA, idB + 2, BB)));
        }
    }
}