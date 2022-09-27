public class TIK {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.printf(
                    "n = %3d, k > log3(2n + 1) = %3d, log3(n/3) + 2 = %3d\n",
                    i,
                    (int) (Math.floor(Math.log(2*i + 1)/Math.log(3)) + 1),
                    (int) (Math.ceil(Math.log((int)(i/3))/Math.log(3) + 2))
            );
        }
    }
}
