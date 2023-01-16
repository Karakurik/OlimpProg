import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class G {
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
        Set<Integer>[] arr = new Set[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new HashSet<>();
        }
        for (int i = 0; i < m; i++) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            arr[x].add(y);
            arr[y].add(x);
        }
        for (int i = 0; i < n; i++) {
            Set<Integer> friends2 = new HashSet<>();
            for (int f : arr[i]) {
                friends2.addAll(arr[f]);
            }
            friends2.removeAll(arr[i]);
            friends2.remove(i);
            int cou = 0;
            TreeSet<Integer> ansFriends = new TreeSet<>();
            for (int cand : friends2) {
                Set<Integer> fr = new HashSet<>(arr[cand]);
                fr.retainAll(arr[i]);
                if (fr.size() > cou) {
                    ansFriends.clear();
                    cou = fr.size();
                }
                if (fr.size() == cou) {
                    ansFriends.add(cand);
                }
            }
            if (ansFriends.isEmpty()) {
                pw.println(0);
            } else {
                for (int el : ansFriends) {
                    pw.print((el + 1) + " ");
                }
                pw.println();
            }
        }
    }
}
