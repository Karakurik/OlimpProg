import java.io.PrintWriter;
import java.math.BigInteger;

public class Tinkoff {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out, false);
        BigInteger val100 = new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");
        for (int x = 0; x < 1_000_000_000; x++) {
            BigInteger bigx = new BigInteger(String.valueOf(x));
            boolean flag = true;
            for (int y = 0; y < 1_000_000; y++) {
                BigInteger bigy = new BigInteger(String.valueOf(y));
                if (!val100.gcd(bigx).equals(val100.gcd(bigy))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                pw.println(x);
                return;
            }
        }
        pw.close();
    }
}
