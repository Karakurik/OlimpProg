import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = nextInt();
        if (n != 0) {
            int p = nextInt();
            pw.println(p);
            for (int i = 1; i < n; i++) {
                int t = nextInt();
                if (t != p) {
                    p = t;
                    pw.println(t);
                }
            }
        }
        pw.close();
    }

    static int nextInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
