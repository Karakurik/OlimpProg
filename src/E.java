import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

public class E {
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

    static Map<String, String> map;

    static String generateString(int n) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) (random.nextInt(26) + 'A'));
        }
        return sb.toString();
    }

    static int length;

    private static void solve() {
        String s = nextLine();
//        String s = generateString(1000);
        length = s.length();
        map = new HashMap<>();
        map.put("", "");
        dp(s, 0);
        pw.println(map.get(s));
    }

    private static void dp(String s, int id) {
        if (s.length() <= 0) return;
        String test = "";
        if (!map.containsKey(s)) {
            map.put(s, s);
            if (s.length() == 1) return;
            for (int i = 1; i < s.length(); i++) {
                String substr = s.substring(0, i);
                String substr2 = s.substring(i);
                dp(substr2, id + i);
                if (map.containsKey(substr2)) {
                    if (map.get(substr2).length() + i < map.get(s).length()) {
                        map.put(s, substr + map.get(substr2));
                    }
                }
                int cou = 1;
                while (substr2.startsWith(substr)) {
                    cou++;
                    if (map.containsKey(substr2)) {
                        // TODO: 25.03.2022 solve this fuck 
                        test = cou + "(" + map.get(substr2) + ")";
                        if (test.length() < map.get(s).length()) {
                            map.put(s, test);
                        }
                    }
                    substr2 = substr2.substring(i);
                    if (id + cou * i <= length) {
                        dp(substr2, id + cou * i);
                        test = cou + "(" + substr + ")" + map.get(substr2);
                        if (test.length() < map.get(s).length()) {
                            map.put(s, test);
                        }
                    }
                }
            }
        }
    }
}

//AAAAAAAAAABABABCCD    9(A)3(AB)CCD

//NEERCYESYESYESNEERCYESYESYES 2(NEERC3(YES))
