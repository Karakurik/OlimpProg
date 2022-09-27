package task_fibonacсi_last_10_digits;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class SolvingImba {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        solve();
        pw.close();
    }

    static int countOfDigits = 10;

    public static void solve() {
        BigInteger n = new BigInteger(sc.nextLine());

        BigDecimal f = BigDecimal.valueOf((1 + Math.sqrt(5)) / 2);
        BigDecimal k = BigDecimal.valueOf(Math.sqrt(5)).multiply(BigDecimal.valueOf(2));

        for (int i = 0; i <= 11; i++) {
            pw.printf("f(%d) = %d\n", i, fastPowerLog(f, BigInteger.valueOf(i)).multiply(k)
                    .setScale(0, RoundingMode.HALF_UP)
                    .movePointLeft(1)
                    .toBigInteger()
            );
        }

        pw.printf("f(%d) = %d\n", n, fastPowerLog(f, n).multiply(k)
                .setScale(0, RoundingMode.HALF_UP)
                .movePointLeft(1)
                .toBigInteger()
        );
    }

    public static BigDecimal fastPowerLog(BigDecimal d, BigInteger n) {
        d = cast(d);
        BigDecimal result = BigDecimal.ONE;
        while (n.compareTo(BigInteger.ZERO) > 0) {
            if (n.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE)) {
                result = cast(result.multiply(d));
                n = n.subtract(BigInteger.ONE);
            } else {
                d = cast(d.multiply(d));
                n = n.divide(BigInteger.valueOf(2));
            }
        }
        return result;
    }

    public static BigDecimal cast(BigDecimal d) {
        return new BigDecimal(d.toString().substring(Math.max(0, d.toString().indexOf(".") - (countOfDigits + 1))))
                .setScale(countOfDigits, RoundingMode.DOWN);
    }
}
