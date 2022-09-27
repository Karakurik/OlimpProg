import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D {
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
        int k = nextInt();
        int id = 1;
        int[] answer = new int[n];
        int answerId = 0;
        int[] zapas = new int[n];
        Queue<Day>[] stopks = new Queue[k];
        for (int i = 0; i < stopks.length; i++) {
            stopks[i] = new LinkedList<>();
        }
        Comparator<Day> comparator = (o1, o2) -> {
            if (o1.zap + zapas[o1.stopka] - o2.zap + zapas[o2.stopka] != 0) {
                return o1.zap + zapas[o1.stopka] - o2.zap + zapas[o2.stopka];
            } else {
                return o1.day - o2.day;
            }
        };
        TreeSet<Day> set = new TreeSet<>(comparator);
        int dayNumber = 1;
        for (int i = 0; i < k; i++) {
            int cou = nextInt();
            for (int j = 0; j < cou; j++) {
                int t = nextInt();
                Day d = new Day(dayNumber++, t - j, i);
                set.add(d);
                stopks[i].add(d);
            }
        }
        while (!set.isEmpty()) {
            Set<Day> removedDays = new HashSet<>();
            Day minimum = set.first();
            if (minimum.zap + zapas[minimum.stopka] - answerId <= 0) {
                pw.println("No");
                return;
            }
            while (stopks[minimum.stopka].peek() != minimum) {
                Day removed = stopks[minimum.stopka].poll();
                if (removed.zap + zapas[removed.stopka] - answerId <= 0) {
                    pw.println("No");
                    return;
                }
                answer[answerId++] = removed.day;
                zapas[minimum.stopka]++;
                removedDays.add(removed);
            }
            if (minimum.zap + zapas[minimum.stopka] - answerId <= 0) {
                pw.println("No");
                return;
            }
            answer[answerId++] = minimum.day;
            zapas[minimum.stopka]++;
            stopks[minimum.stopka].poll();
            removedDays.add(minimum);
            TreeSet<Day> newSet = new TreeSet<>(comparator);
            for (Day d : set) {
                if (removedDays.contains(d)) {

                } else {

                    newSet.add(d);
                }
            }
            set = newSet;
        }

        pw.println("Yes");
        for (int i : answer) {
            pw.print(i + " ");
        }
        pw.println();
    }

    static class Day {
        int day;
        int zap;
        int stopka;

        public Day(int day, int zap, int stopka) {
            this.day = day;
            this.zap = zap;
            this.stopka = stopka;
        }
    }
}
