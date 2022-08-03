public class Km {
    static long accum = 0;
    static int SIZE = 19;
    static boolean[] used = new boolean[SIZE];
    
    public static void main(String[] args) {
        counter(0);
        System.out.println(accum);
    }

    public static void counter(int x) {
        if (x == SIZE) {
            accum++;
            return;
        }
        if (x > 0 && used[x - 1]) {
            counter(x+1); // случай, когда предыдущее место занято
        } else {
            used[x] = true;
            counter(x+1); // сажаем чела считаем дальше
            used[x] = false;
            counter(x+1); // оставляем пустым, считаем дальше
        }
    }
}