import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class J {
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
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    static List<Set<Character>> list;
    private static void solve() {
        char[] arr = nextLine().toCharArray();
        int n = arr.length - 1;
        list = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            if (list.size() == 1 && list.get(0).size() == 26) {
                break;
            }
            char char1 = arr[i];
            char char2 = arr[n - i];
            if (arr[i] == arr[n - i]) continue;
            boolean flag = false;
            for (Set set : list) {
                if (set.contains(char1)) {
                    if (set.contains(char2)) {
                        flag = true;
                        break;
                    }
                    set.add(char2);
                }
            }
            if (flag) continue;
            ans++;

            for (Set set : list) {
                if (set.contains(char2)) {
                    set.add(char1);
                }
            }

            int size = list.size();
            mergeSets(char1);

            if (size==list.size()) {
                HashSet<Character> hashSet = new HashSet<>();
                hashSet.add(char1);
                hashSet.add(char2);
                list.add(hashSet);
            }
        }
        pw.println(ans);
    }

    private static void mergeSets(char char1) {
        int id = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(char1)) {
                for (int j = i+1; j < list.size(); j++) {
                    if (list.get(j).contains(char1)) {
                        for (Character c : list.get(j)) {
                            list.get(i).add(c);
                        }
                        id = j;
                    }
                }
            }
        }
        if (id!=-1) {
            list.remove(id);
        }
    }
}
