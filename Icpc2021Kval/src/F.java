import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class F {
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
//        br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
//        pw = new PrintWriter(new FileWriter("output.txt"));
        pw = new PrintWriter(System.out);

        int t = 1;
//        t = nextInt();
        while (t-- > 0) {
            solve();
        }
        pw.close();
    }

    private static void solve() {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] primeUsed = new boolean[1_000_001];
        for (int i = 2; i < primeUsed.length; i++) {
            if (!primeUsed[i]) {
                primeNumbers.add(i);
                for (int j = 2 * i; j < primeUsed.length; j += i) {
                    primeUsed[j] = true;
                }
            }
        }

        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        answers = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int t = arr[i];
            if (t == 1) {
                add(1, arr[i]);
                continue;
            }
            List<XwithCou> primesCount = new ArrayList<>();
            int primeId = 0;
            while (t > 1) {
                if (primeId >= primeNumbers.size()) break;
                int cou = 0;
                while (t % primeNumbers.get(primeId) == 0) {
                    cou++;
                    t /= primeNumbers.get(primeId);
                }
                if (cou > 0) {
                    primesCount.add(new XwithCou(primeNumbers.get(primeId), cou));
                }
                primeId++;
            }
            if (t > 1) {
                primesCount.add(new XwithCou(t, 1));
                t = 1;
            }
            if (primesCount.size() > 0) {

                XwithCou xwithCou = primesCount.get(0);
                boolean flag = true;
                for (XwithCou xwithCou1 : primesCount) {
                    if (flag) {
                        flag = false;
                        continue;
                    }
                    if (xwithCou.cou == xwithCou1.cou) {
                        xwithCou.x *= xwithCou1.x;
                    } else {
                        xwithCou.x = (int) (Math.pow(xwithCou.x, xwithCou.cou) * Math.pow(xwithCou1.x, xwithCou1.cou));
                        xwithCou.cou = 1;
                    }
                }
                while (xwithCou.cou >= 1) {
                    add(xwithCou.x, arr[i]);
                    if (xwithCou.cou % 2 == 0) {
                        xwithCou.x = xwithCou.x * xwithCou.x;
                        xwithCou.cou /= 2;
                    } else if (xwithCou.cou > 1) {
                        xwithCou.x = (int) Math.pow(xwithCou.x, xwithCou.cou);
                        xwithCou.cou = 1;
                    } else {
                        break;
                    }
                }
            } else {
                add(arr[i], arr[i]);
            }
        }
        pw.println(Collections.max(answers.values()));
    }

    static class XwithCou {
        int x;
        int cou;

        public XwithCou(int x, int cou) {
            this.x = x;
            this.cou = cou;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            XwithCou xwithCou = (XwithCou) o;
            return x == xwithCou.x && cou == xwithCou.cou;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, cou);
        }
    }

    static Map<Integer, Long> answers;

    public static void add(Integer x, Integer val) {
        if (answers.containsKey(x)) {
            answers.put(x, answers.get(x) + val);
        } else {
            answers.put(x, (long) val);
        }
    }
}