public class Km {
    static long[] ans;
    static long accum = 0;
    static int SIZE = 19;
    static boolean[] used = new boolean[SIZE];

    public static void main(String[] args) {
        ans = new long[11];
        counter(0);
        System.out.println(accum);
        System.out.println(ans.toString());
    }

    public static void counter(int x) {
        if (x == SIZE) {
            accum++;
            int cou = 0;
            for (boolean f : used) {
                if (f) cou++;
            }
            ans[cou]++;
            return;
        }
        if (x > 0 && used[x - 1]) {
            counter(x + 1); // случай, когда предыдущее место занято
        } else {
            used[x] = true;
            counter(x + 1); // сажаем чела считаем дальше
            used[x] = false;
            counter(x + 1); // оставляем пустым, считаем дальше
        }
    }
}
