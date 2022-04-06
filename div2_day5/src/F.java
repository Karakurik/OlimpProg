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

//        int t = nextInt();
//        while (t-- > 0) {
//            solve();
//        }
        solve();
        pw.close();
    }

    private static void solve() {
        int n = nextInt();
        int k = nextInt();
        int[][] arr = new int[n+1][2];
        arr[0][0] = -1;arr[0][0] = 0;
        for (int i = 0; i < n; i++) {
            arr[i+1][0] = nextInt();
            arr[i+1][1] = i+1;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        List<String> list = new ArrayList<>(); //Ответы

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        int next = 2;
        int[] kArray = new int[n+1];
        for (int i = 0; i < n; i++) {
            kArray[i+1] = k;
        }

        while (!stack.isEmpty() && next<=n) {
            while (kArray[stack.peek()]>0){
                kArray[stack.peek()]--;
                if (arr[next][0] <= arr[stack.peek()][0]) break;
                list.add(arr[stack.peek()][1] + " " + arr[next][1]);
                stack.add(next);
                next++;
                if (next>n) break;
            }
            stack.pop();
        }

//        ВЫВОД
        if (next > n) {
            if (list.size()==0) {
                pw.println(0);
            }
            pw.println(list.size());
            for(String s:list) {
                pw.println(s);
            }
        } else {
            pw.println(-1);
        }
    }
}