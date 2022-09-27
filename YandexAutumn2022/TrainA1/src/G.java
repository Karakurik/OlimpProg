import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class G {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out, true);
    static StringTokenizer st;

    public static void main(String[] args) {
        int n = nextInt();
        int[][] arr = new int[n+1][2];
        int[] ans = new int[n+1];
        Set<Integer> notUsed = new HashSet<>();
        for (int i = 1; i <=n ; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = nextInt();
            notUsed.add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        int k = nextInt();
        int start = nextInt();
        int end = nextInt();

        queue.add(start);
        while (!queue.isEmpty()) {
            int elem = queue.poll();
            notUsed.remove(elem);
            for (Object e: notUsed.toArray()) {
                int node = (int)e;
                if (Math.abs(arr[elem][0] - arr[node][0]) <= k - Math.abs(arr[elem][1] - arr[node][1])) {
                    ans[node] = ans[elem] + 1;
                    queue.add(node);
                    notUsed.remove(node);
                    if (node == end) {
                        pw.println(ans[node]);
                        return;
                    }
                }
            }
        }
        pw.println(-1);
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

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
}
