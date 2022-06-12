import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        int n = 6;
        Integer[] arr = new Integer[6];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        double ans = 0.0;
        Set<Integer[]> set = getPermutationsRecursive(arr);
        for (Integer[] per : set) {
            ans = Math.max(cals(per), ans);
        }

        pw.println(ans);

    }

    private static double cals(Integer[] per) {
        double sum = 0.0;
        for (int i = 0; i < 6; i++) {
            sum += 0.25 * per[i] * per[(i + 1) % 6] * Math.sqrt(3.0);
        }
        return sum;
    }

    public static Set<Integer[]> getPermutationsRecursive(Integer[] num) {
        if (num == null)
            return null;

        Set<Integer[]> perms = new HashSet<>();

        //base case
        if (num.length == 0) {
            perms.add(new Integer[0]);
            return perms;
        }

        //shave off first int then get sub perms on remaining ints.
        //...then insert the first into each position of each sub perm..recurse

        int first = num[0];
        Integer[] remainder = Arrays.copyOfRange(num, 1, num.length);
        Set<Integer[]> subPerms = getPermutationsRecursive(remainder);
        for (Integer[] subPerm : subPerms) {
            for (int i = 0; i <= subPerm.length; ++i) { // '<='   IMPORTANT !!!
                Integer[] newPerm = Arrays.copyOf(subPerm, subPerm.length + 1);
                for (int j = newPerm.length - 1; j > i; --j)
                    newPerm[j] = newPerm[j - 1];
                newPerm[i] = first;
                perms.add(newPerm);
            }
        }

        return perms;
    }
}
