package bileti_100;

import java.math.BigInteger;
import java.util.Arrays;

public class Solving {
    public static void main(String[] args) {

        int n = 3;
        BigInteger[][] ans = new BigInteger[2 * n + 1][18 * n + 1];
        for (BigInteger[] st : ans) {
            Arrays.fill(st, BigInteger.ZERO);
        }
        ans[0][0] = BigInteger.ONE;
        for (int i = 1; i <= 2 * n; i++) {
            for (int k = 0; k <= 9 * i; k++) {
                for (int j = 0; j < 10; j++) {
                    if (k - j >= 0) {
                        ans[i][k] = ans[i][k].add(ans[i - 1][k - j]);
                    }
                }
            }
        }
        System.out.println(ans[2 * n][9 * n]);
    }
}

//138681178063913146486663255108385891670476531416644888545033078503482282975641730091720919340564340
