import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Kov {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        Arrays.stream(new Scanner(System.in).nextLine().split("\"")).forEach(e -> {
            if (i.getAndIncrement() %2!=0) System.out.println(e);
        });
    }


}
