import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Task6 {
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

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        int q = nextInt();
        Tree tree = new Tree();
        int sum = 0;
        for (int i = 0; i < q; i++) {
            int k = nextInt();
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < step; j++) {
                a.add(0);
            }
            for (int j = 0; j < step; j++) {
                a.set(step - j - 1, k & 1);
                k >>= 1;
            }

            sum = Math.max(findInTree(tree, a, 0), sum);
            pw.println(sum);

            addToTree(tree, a, 0);
        }
        pw.close();
    }

    private static final int step = 32;

    static class Tree {
        Tree left;
        Tree right;
    }

    static void addToTree(Tree tree, List<Integer> a, int pos) {
        if (pos == a.size()) return;

        if (a.get(pos) == 0) {
            if (tree.left == null) {
                tree.left = new Tree();
            }
            addToTree(tree.left, a, pos + 1);
        } else {
            if (tree.right == null) {
                tree.right = new Tree();
            }

            addToTree(tree.right, a, pos + 1);
        }
    }

    static int findInTree(Tree tree, List<Integer> a, int pos) {
        if (pos == a.size()) return 0;

        if (tree.left == null && tree.right == null) return 0;

        if (a.get(pos) == 0) {
            if (tree.right != null) {
                int res = findInTree(tree.right, a, pos + 1);
                return ((1 << (step - pos - 1)) + res);
            } else {
                return findInTree(tree.left, a, pos + 1);
            }
        } else {
            if (tree.left != null) {
                int res = findInTree(tree.left, a, pos + 1);
                return ((1 << (step - pos - 1)) + res);
            } else {
                return findInTree(tree.right, a, pos + 1);
            }
        }
    }
}

/* test1
4
3
2
5
2
*/

/* answer1
0
1
7
7
*/
