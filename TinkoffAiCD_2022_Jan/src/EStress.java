import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class EStress {
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
//        int n = nextInt();
        for (int n = 1; n <= 100000; n++) {


            int sum3 = n * (n + 1) / 2;
            if (sum3 % 3 != 0) {
                pw.println(-1);
                continue;
            }
            if (n > sum3 / 3) {
                pw.println(-1);
                continue;
            }

            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            List<Integer> list3 = new ArrayList<>();

            Queue<Integer> queue = new LinkedList<>();
            for (int i = n; i > 0; i--) {
                queue.add(i);
            }

            int sum = sum3 / 3;
            while (sum >= queue.peek()) {
                list1.add(queue.peek());
                sum -= queue.poll();
            }
            if (sum != 0) {
                if (queue.contains(sum)) {
                    list1.add(sum);
                    queue.remove(sum);
                } else {
                    pw.println(-1);
                    throw new RuntimeException(String.valueOf(n));
//                return;
                }
            }

            sum = sum3 / 3;
            while (sum >= queue.peek()) {
                list2.add(queue.peek());
                sum -= queue.poll();
            }
            if (sum != 0) {
                if (queue.contains(sum)) {
                    list2.add(sum);
                    queue.remove(sum);
                } else {
                    if (sum >= 3) {
                        list2.add(sum - 1);
                        queue.remove(sum - 1);
                        list2.add(1);
                        queue.remove(1);
                    } else {
                        pw.println(-1);
                        throw new RuntimeException(String.valueOf(n));
//                        return;
                    }
                }
            }
            while (!queue.isEmpty()) {
                list3.add(queue.poll());
            }

//            pw.println(list1.size());
//            for (Integer i : list1) {
//                pw.print(i + " ");
//            }
//            pw.println();
//            pw.println();
//
//            pw.println(list2.size());
//            for (Integer i : list2) {
//                pw.print(i + " ");
//            }
//            pw.println();
//            pw.println();
//
//            pw.println(list3.size());
//            for (Integer i : list3) {
//                pw.print(i + " ");
//            }
//            pw.println();

            pw.println(n);
        }
    }
}
