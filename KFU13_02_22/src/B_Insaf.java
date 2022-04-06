import java.util.Scanner;

public class B_Insaf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int n = sc.nextInt();
        int y = count(n);
        if (n % 4 == 0) arr[2] = 29;
        int ans = 0;
        for (int m = 1; m < 13; m++) {
            for (int d = 1; d <= arr[m]; d++) {
                if (y == count(d) + count(m)) {
                    ans++;
//                    System.out.println(d+"."+m+"."+n);
                }
            }
        }
        System.out.println(ans);
    }

    private static int count(int n) {
        int cou = 0;
        while (n > 0) {
            cou += n % 10;
            n /= 10;
        }
        return cou;
    }
}
