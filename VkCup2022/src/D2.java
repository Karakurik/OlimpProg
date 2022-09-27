import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D2 {
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

    static boolean[][] cards = new boolean[9][4];

    static int DEVYATKA = 3;

    static Set<Pair> alice = new HashSet<>();
    static Set<Pair> bob = new HashSet<>();

    private static ReturnPair game(int aliceCount, int bobCount, boolean current) {
        if (aliceCount == 18) return new ReturnPair(true, aliceCount - bobCount);
        if (bobCount == 18) return new ReturnPair(false, bobCount - aliceCount);

        if (current) {
            if (alice.isEmpty()) return game(aliceCount, bobCount, !current);

            Pair support = alice.stream().filter(p -> check(p, current)).findFirst().orElse(null);

            if (support != null) {
                addNew(support);
                alice.remove(support);
                ReturnPair res = game(aliceCount + 1, bobCount, !current);
                alice.add(support);
                removeNew(support);
                return new ReturnPair(res.who == current, res.vaz);
            } else {
                Set<Pair> help = new HashSet<>(alice);
                ReturnPair res = null;
                for (Pair p : help) {
                    addNew(p);
                    alice.remove(p);
                    res = game(aliceCount + 1, bobCount, !current);
                    alice.add(p);
                    removeNew(p);
                    if (res.who == current) return res;
                }
                return new ReturnPair(!current, 0);
            }
        } else {
            if (bob.isEmpty()) return game(aliceCount, bobCount, !current);

            Pair support = bob.stream().filter(p -> check(p, current)).findFirst().orElse(null);

            if (support != null) {
                addNew(support);
                bob.remove(support);
                ReturnPair res = game(aliceCount, bobCount + 1, !current);
                bob.add(support);
                removeNew(support);
                return new ReturnPair(res.who != current, res.vaz);
            } else {
                Set<Pair> help = new HashSet<>(bob);
                ReturnPair res = null;
                for (Pair p : help) {
                    addNew(p);
                    bob.remove(p);
                    res = game(aliceCount, bobCount + 1, !current);
                    bob.add(p);
                    removeNew(p);
                    if (res.who == current) return res;
                }
                return new ReturnPair(!current, 0);
            }
        }
    }

    private static void removeNew(Pair p) {
        if (p.f == 0 || p.f == 8) return;

        if (p.f >= DEVYATKA) {
            if (cards[p.f + 1][p.s]) alice.remove(new Pair(p.f + 1, p.s));
            else bob.remove(new Pair(p.f + 1, p.s));
        }

        if (p.f <= DEVYATKA) {
            if (cards[p.f - 1][p.s]) alice.remove(new Pair(p.f - 1, p.s));
            else bob.remove(new Pair(p.f - 1, p.s));
        }
    }

    private static void addNew(Pair p) {
        if (p.f == 0 || p.f == 8) return;

        if (p.f >= DEVYATKA) {
            if (cards[p.f + 1][p.s]) alice.add(new Pair(p.f + 1, p.s));
            else bob.add(new Pair(p.f + 1, p.s));
        }

        if (p.f <= DEVYATKA) {
            if (cards[p.f - 1][p.s]) alice.add(new Pair(p.f - 1, p.s));
            else bob.add(new Pair(p.f - 1, p.s));
        }
    }

    static class Pair {
        int f;
        int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;

            if (f != pair.f) return false;
            return s == pair.s;
        }

        @Override
        public int hashCode() {
            int result = f;
            result = 31 * result + s;
            return result;
        }
    }

    static class ReturnPair {
        boolean who;
        int vaz;

        public ReturnPair(boolean who, int vaz) {
            this.who = who;
            this.vaz = vaz;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ReturnPair that)) return false;

            if (who != that.who) return false;
            return vaz == that.vaz;
        }

        @Override
        public int hashCode() {
            int result = (who ? 1 : 0);
            result = 31 * result + vaz;
            return result;
        }
    }

    private static boolean check(Pair p, boolean current) {
        if (p.f == 0 || p.f == 8) return true;

        if (p.f < DEVYATKA) {
            return cards[p.f - 1][p.s] == current;
        }

        if (p.f > DEVYATKA) {
            return cards[p.f + 1][p.s] == current;
        }

        return cards[p.f - 1][p.s] == current && cards[p.f + 1][p.s] == current;
    }

    private static void printAnswer(ReturnPair current) {
        if (current.who) {
            pw.println("Alice");
        } else {
            pw.println("Bob");
        }
        pw.println(current.vaz);
    }

    private static void solve() {
        String str1 = "6789TJQKA";
        String str2 = "CDSH";

        String string1 = nextLine();
        String string2 = nextLine();
        for (String s1 : string1.split(" ")) {
            cards[str1.indexOf(s1.charAt(0))][str2.indexOf(s1.charAt(1))] = true;
        }
        for (String s1 : string2.split(" ")) {
            cards[str1.indexOf(s1.charAt(0))][str2.indexOf(s1.charAt(1))] = false;
        }

        for (int i = 0; i < 4; i++) {
            if (cards[DEVYATKA][i]) alice.add(new Pair(DEVYATKA, i));
            else bob.add(new Pair(DEVYATKA, i));
        }

        printAnswer(game(0, 0, true));
        printAnswer(game(0, 0, false));
    }
}
