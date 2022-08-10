import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToTinkOff {
    public static void main(String[] args) {
        java17();
    }

    public static void java2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
    }

    public static void java9() {
        List list = new ArrayList(10);
        for (int i = 0; i < 11; i++) {
            list.add(new Object());
        }
    }

    public static void java11() {
        try {
            new FileInputStream("").read();
        } catch (IOException | NullPointerException e) {
            //...
        }
    }

    public static void java12() {
        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        System.out.println(i1 + i2);
    }

    public static void java16() {
        int k = 0;
        for (int i = 0; i < 10; i++) {
            k = k++;
        }
        System.out.println(k);
    }

    public static void java17() {
        List<String> numbers = new ArrayList(Arrays.asList("first", "second", "third"));
        for (String number : numbers) {
            if ("third".equals(number)) {
                numbers.add("fourth");
            }
        }
        System.out.println(numbers.size());
    }

    public static void android11() {
        Integer i = 42;
        String s = (i < 40) ? "life" : (i > 50) ? "universe" : "everything";
        System.out.print(s);
    }

    public static void android12() {
        Boolean a = true;
        Boolean b = false;
        Boolean c = true;
        if (a || b && c)
            System.out.print("Hello ");
        if (a && !b && c)
            System.out.print("World");
    }

    public static void android14() {
        if (one() & two() | one()) {
            System.out.print("three");
        }
    }

    private static boolean two() {
        System.out.print("two");
        return false;
    }

    private static boolean one() {
        System.out.print("one");
        return true;
    }
}
