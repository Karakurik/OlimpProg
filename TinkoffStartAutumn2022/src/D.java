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
//        br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\OlimpProg\\TinkoffStartAutumn2022\\src\\input.txt")));
        pw = new PrintWriter(System.out);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() throws IOException {
        Block current = new Block();
        String s;
        while ((s = br.readLine()) != null) {
            if (s.equals("{")) {
                Block block = new Block();
                block.parent = current;
                block.vars = new HashMap<>(current.vars);
                current = block;
            } else if (s.equals("}")) {
                current = current.parent;
            } else {
                String[] arr = s.split("=");
                if (current.vars.containsKey(arr[1])) {
                    current.vars.put(arr[0], current.vars.get(arr[1]));
                    pw.println(current.vars.get(arr[0]));
                } else {
                    try {
                        current.vars.put(arr[0], Integer.parseInt(arr[1]));
                    } catch (Exception e) {
                        current.vars.put(arr[0], 0);
                        pw.println(0);
                    }
                }
            }
            pw.flush();
        }
    }

    private static class Block {
        Block parent;
        Map<String, Integer> vars;

        public Block() {
            this.vars = new HashMap<>();
        }
    }
}

/* Test1
thats=zero
a=10
ten=a
aboba=ten
ten=-10
{
b=a
a=1337
c=a
{
d=a
e=aboba
}
}
lol=a
*/

/* Answer1
0
10
10
10
1337
1337
10
10
*/
