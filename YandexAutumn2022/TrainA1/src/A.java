import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int ans = 0;
        for (char c : sc.nextLine().toCharArray()) {
            if (s1.indexOf(c) >= 0) ans++;
        }
        System.out.println(ans);
    }
}
