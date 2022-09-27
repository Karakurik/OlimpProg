import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int cou = 0;
        for (int i = 0; i < n; i++) {
            if (sc.nextInt() == 1) {
                cou++;
            } else {
                ans = Math.max(ans, cou);
                cou = 0;
            }
        }
        ans = Math.max(ans, cou);
        System.out.println(ans);
    }
}
