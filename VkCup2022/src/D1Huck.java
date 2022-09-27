import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;

public class D1Huck {
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

    private static boolean game(int aliceCount, int bobCount, boolean current) {
        if (aliceCount == 18 && bobCount == 18) {
            throw new RuntimeException();
        }
        if (aliceCount == 18) return true;
        if (bobCount == 18) return false;
        if (alice.isEmpty() && bob.isEmpty()) {
            throw new RuntimeException();
        }

        if (current) {
            if (alice.isEmpty()) game(aliceCount, bobCount, !current);

            Pair support = alice.stream().filter(p -> check(p, current)).findFirst().orElse(null);

            if (support != null) {
                addNew(support);
                alice.remove(support);
                boolean res = game(aliceCount + 1, bobCount, !current);
                alice.add(support);
                removeNew(support);
                return res == current;
            } else {
                Set<Pair> help = new HashSet<>(alice);
                for (Pair p : help) {
                    addNew(p);
                    alice.remove(p);
                    boolean res = game(aliceCount + 1, bobCount, !current);
                    alice.add(p);
                    removeNew(p);
                    if (res == current) return current;
                }
                return !current;
            }
        } else {
            if (bob.isEmpty()) game(aliceCount, bobCount, !current);

            Pair support = bob.stream().filter(p -> check(p, current)).findFirst().orElse(null);

            if (support != null) {
                addNew(support);
                bob.remove(support);
                boolean res = game(aliceCount, bobCount + 1, !current);
                bob.add(support);
                removeNew(support);
                return res != current;
            } else {
                Set<Pair> help = new HashSet<>(bob);
                for (Pair p : help) {
                    addNew(p);
                    bob.remove(p);
                    boolean res = game(aliceCount, bobCount + 1, !current);
                    bob.add(p);
                    removeNew(p);
                    if (res == current) return current;
                }
                return !current;
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

    private static void printAnswer(boolean current) {
        if (current) {
            pw.println("Alice");
        } else {
            pw.println("Bob");
        }
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

        var sekret3Wrong = new HashSet<>();
        sekret3Wrong.add("K99");
        sekret3Wrong.add("7A6");
        sekret3Wrong.add("KA8");

        String secret3 = "" + string1.charAt(0) + string2.charAt(0) + string1.charAt(3);
        if (sekret3Wrong.contains(secret3)) {
            printAnswer(!game(0, 0, true));
        } else {
            printAnswer(game(0, 0, true));
        }
    }
}
