import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        if (c == 0 && d == 0) {
            System.out.println("NO");
            return;
        }
        if (b == 0) {
            if (a == 0) {
                System.out.println("INF");
            } else {
                System.out.println(0);
            }
        } else {
            if (a == 0) {
                System.out.println("NO");
            } else {
                int ans = (-b / a);
                if (ans * a == -b) {
                    if (c * ans + d == 0) {
                        System.out.println("NO");
                    } else {
                        System.out.println(ans);
                    }
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}