import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

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

    private static void solve() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("66", "Alice"); // Alice
//        map.put("67", "Alice");
//        map.put("68", "Alice");
//        map.put("69", "Alice");
//        map.put("6T", "Alice");
//        map.put("6J", "Alice");
        map.put("6Q", "Bob"); // Bob
//        map.put("6K", "Alice");
//        map.put("6A", "Alice");
//        map.put("76", "Alice");
//        map.put("77", "Alice");
        map.put("78", "Bob"); //Bob
//        map.put("79", "Alice");
//        map.put("7T", "Alice");
//        map.put("7J", "Alice");
//        map.put("7Q", "Alice");
//        map.put("7K", "Alice");
//        map.put("7A", "Alice");
//        map.put("86", "Alice");
//        map.put("87", "Alice");
//        map.put("88", "Alice");
//        map.put("89", "Alice");
//        map.put("8T", "Alice");
//        map.put("8J", "Alice");
//        map.put("8Q", "Alice");
//        map.put("8K", "Alice");
//        map.put("8A", "Alice");
//        map.put("96", "Alice");
//        map.put("97", "Alice");
//        map.put("98", "Alice");
//        map.put("99", "Alice");
//        map.put("9T", "Alice");
//        map.put("9J", "Alice");
//        map.put("9Q", "Alice");
//        map.put("9K", "Alice");
//        map.put("9A", "Alice");
//        map.put("T6", "Alice");
//        map.put("T7", "Alice");
//        map.put("T8", "Alice");
//        map.put("T9", "Alice");
//        map.put("TT", "Alice");
//        map.put("TJ", "Alice");
//        map.put("TQ", "Alice");
//        map.put("TK", "Alice");
//        map.put("TA", "Alice");
//        map.put("J6", "Alice");
//        map.put("J7", "Alice");
        map.put("J8", "Bob"); // Bob
//        map.put("J9", "Alice");
//        map.put("JT", "Alice");
//        map.put("JJ", "Alice");
//        map.put("JQ", "Alice");
        map.put("JK", "Alice"); // Alice
//        map.put("JA", "Alice");
//        map.put("Q6", "Alice");
//        map.put("Q7", "Alice");
//        map.put("Q8", "Alice");
//        map.put("Q9", "Alice");
//        map.put("QT", "Alice");
//        map.put("QJ", "Alice");
//        map.put("QQ", "Alice");
//        map.put("QK", "Alice");
//        map.put("QA", "Alice");
//        map.put("K6", "Alice");
//        map.put("K7", "Alice");
//        map.put("K8", "Alice");
//        map.put("K9", "Alice");
//        map.put("KT", "Alice");
//        map.put("KJ", "Alice");
//        map.put("KQ", "Alice");
//        map.put("KK", "Alice");
//        map.put("KA", "Alice");
//        map.put("A6", "Alice");
//        map.put("A7", "Alice");
//        map.put("A8", "Alice");
//        map.put("A9", "Alice");
//        map.put("AT", "Alice");
//        map.put("AJ", "Alice");
//        map.put("AQ", "Alice");
//        map.put("AK", "Alice");
//        map.put("AA", "Alice");
        char c1 = nextLine().charAt(0);
        char c2 = nextLine().charAt(0);
        String s = "" + c1 + c2;
        if (map.containsKey(s)) {
            pw.println(map.get(s));
        } else {
            if (c1 == '7') {
                pw.println("Bob");
            } else {
                throw new RuntimeException();
            }
        }
    }
}
