import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class D {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static StringBuilder ans = new StringBuilder("(");
    static int n;

    public static void main(String[] args) {
        try {
            n = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        generate(1, 0);

        pw.close();
    }

    private static void generate(int couOpen, int couClose) {
        if (couOpen + couClose == 2 * n) {
            pw.println(ans.toString());
        } else {
            if (couOpen < n) {
                ans.append("(");
                generate(couOpen + 1, couClose);
                ans.deleteCharAt(ans.length() - 1);
            }
            if (couClose < couOpen) {
                ans.append(")");
                generate(couOpen, couClose + 1);
                ans.deleteCharAt(ans.length() - 1);
            }
        }
    }
}
