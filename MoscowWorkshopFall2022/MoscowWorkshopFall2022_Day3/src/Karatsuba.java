public class Karatsuba {
    public static void main(String[] args) {
        long a = 12345;
        long b = 6789;
        long result = karatsuba(a, b);
        System.out.printf("%d * %d = %d", a, b, result);
    }

    private static long karatsuba(long a, long b) {
        if (a < 10 || b < 10) {
            return fallbackMult(a, b);
        }

        int m = Math.min(digits(a), digits(b)) / 2;
        long mPow = multBy10(1, m);

        long a1 = a / mPow;
        long a2 = a % mPow;
        long b1 = b / mPow;
        long b2 = b % mPow;

        long z0 = karatsuba(a1, b1);
        long z1 = karatsuba(a2, b2);
        long z2 = karatsuba(a1 + a2, b1 + b2) - z0 - z1;

        return multBy10(z0, m + m) + multBy10(z2, m) + z1;
    }

    private static long fallbackMult(long a, long b) {
        if (a > b) {
            // make a min
            long tmp = a;
            a = b;
            b = tmp;
        }

        long result = b;
        for (int i = 0; i < a - 1; i++) {
            result += b;
        }

        return result;
    }

    private static long multBy10(long n, int times) {
        for (int i = 0; i < times; i++) {
            n = (n << 3) + (n << 1);
        }
        return n;
    }

    private static int digits(long n) {
        int count = 0;
        for (; n > 0; n /= 10, count++) {}
        return count;
    }
}
