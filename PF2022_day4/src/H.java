import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class H {
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

    public static void main(String[] args) throws FileNotFoundException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream("hard.in")));
        pw = new PrintWriter("hard.out");
//        br = new BufferedReader(new InputStreamReader(System.in));
//        pw = new PrintWriter(System.out);
        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }

        pw.close();
    }

    static int MIN_VALUE = -32768;
    static int MAX_VALUE = 32767;

    private static void solve() {
        List<Grani> list = new ArrayList<>();
        int countOfFalse = 0;
        while (true) {
            Grani g = new Grani();
            String[] st = nextLine().split(" ");
            if (st[1].equals(">=")) {
                g.left = Integer.parseInt(st[2]);
            } else {
                g.right = Integer.parseInt(st[2]);
            }

            if (st.length >= 6) {
                if (st[5].equals(">=")) {
                    g.left = Integer.parseInt(st[6]);
                } else {
                    g.right = Integer.parseInt(st[6]);
                }
            }

            if (g.left <= g.right) {
                list.add(g);
            }

            if (!st[st.length - 1].equals("||")) break;
        }

        if (list.isEmpty()) {
            pw.println("false");
            return;
        }

        list.sort((o1, o2) -> {
            if (o1.left == o2.left) return o1.right - o2.right;
            return o1.left - o2.left;
        });

        List<Grani> answer = new ArrayList<>();
        answer.add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            Grani kand = list.get(i);
            Grani last = answer.get(answer.size() - 1);

            if (kand.left == last.left) {
                last.right = kand.right;
                continue;
            }

            if (kand.left <= last.right || last.right + 1 == kand.left) {
                last.right = Math.max(kand.right, last.right);
                continue;
            }

            if (kand.left > last.right) {
                answer.add(kand);
            }
        }

        if (answer.size() == 1) {
            if (answer.get(0).left == MIN_VALUE && answer.get(0).right == MAX_VALUE) {
                pw.println("true");
                return;
            }
        }

        for (int i = 0; i < answer.size(); i++) {
            Grani g = answer.get(i);
            StringBuilder sb = new StringBuilder();
            if (g.left != MIN_VALUE) {
                sb.append("x >= ");
                sb.append(g.left);
            }
            if (g.right != MAX_VALUE) {
                if (sb.length() > 0) {
                    sb.append(" && ");
                }
                sb.append("x <= ");
                sb.append(g.right);
            }
            if (i != answer.size() - 1) {
                sb.append(" ||");
            }
            pw.println(sb);
        }
    }

    public static class Grani {
        int left = MIN_VALUE;
        int right = MAX_VALUE;

        public Grani() {
        }
    }
}
