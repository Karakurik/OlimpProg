package task_katalana_1_000_000_000;

import java.io.PrintWriter;

public class Solving {
    static PrintWriter pw;


    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        solve();
        pw.close();
    }

    private static void solve() {
        pw.println(
                (int) Math.round(
                        Math.log(1 / (Math.PI * 1_000_000_001)) / Math.log(10)
                                +
                                2_000_000_002 * Math.log(2) / Math.log(10)
                )
        );
    }
}
