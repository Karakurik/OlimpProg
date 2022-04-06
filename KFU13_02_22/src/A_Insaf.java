import java.util.Scanner;

public class A_Insaf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long w = sc.nextLong();
        long n = sc.nextLong();
        long b = sc.nextLong();
        System.out.println((n <= w && w % n <= b) ? w % n : -1);
    }
}
