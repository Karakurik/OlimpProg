package task_fibonacсi_last_10_digits;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Solving {
    static Map<FibPair, BigInteger> map = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        solve();
        pw.close();
    }

    public static void solve() {
        int countOfLastDigits = 10;
        BigInteger n = new BigInteger(sc.nextLine());

        if (n.toString().length() > 10) {
            pw.printf("n = %s, value = 0000000000", n);
            return;
        }

        BigInteger value = BigInteger.ONE;
        BigInteger prevValue = BigInteger.ZERO;
//        if (n.compareTo(new BigInteger("30")) >= 0) {
//            value = new BigInteger("30");
//            while (value.multiply(new BigInteger("10")).compareTo(n) <= 0) {
//                value = value.multiply(new BigInteger("10"));
//            }
//            prevValue = BigInteger.ONE;
//        }

        map.put(new FibPair(value.toString(), prevValue.toString()), BigInteger.ONE);
        for (BigInteger i = value.add(BigInteger.ONE); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            if (i.toString().equals("81")){
                System.out.println();
            }
            String newValue = prevValue.add(value).toString();
            if (newValue.length() > countOfLastDigits) {
                newValue = newValue.substring(newValue.length() - countOfLastDigits);
            }

            FibPair fibPair = new FibPair(newValue, value.toString());

            if (map.containsKey(fibPair)
                    && n.subtract(i)
                    .divide(i.subtract(map.get(fibPair)))
                    .multiply(i.subtract(map.get(fibPair)))
                    .equals(n.subtract(i))
                    || i.equals(n)
            ) {
                pw.printf("n = %s, value = %s\n", n, fibPair.value);
                return;
            } else {
                map.put(fibPair, i);

                prevValue = value;
                value = new BigInteger(newValue);
                pw.printf("n = %s, value = %s\n", i, value);
            }
        }

        pw.printf("n = %s, value = %s\n", n, value);
    }

    private static class FibPair {
        String value;
        String prevValue;

        public FibPair(String value, String prevValue) {
            this.value = value;
            this.prevValue = prevValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FibPair fibPair = (FibPair) o;
            return Objects.equals(value, fibPair.value) && Objects.equals(prevValue, fibPair.prevValue);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, prevValue);
        }
    }
}


// 3000 ->   ...000
// 30000 ->  ...0000
// 300000 -> ...00000