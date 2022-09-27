import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 400 == 0 || n % 4 == 0 && n % 100 != 0) {
            System.out.printf("12/09/%04d", n);
        } else {
            System.out.printf("13/09/%04d", n);
        }
    }
}