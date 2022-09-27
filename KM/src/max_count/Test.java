package max_count;

import java.io.PrintWriter;
import java.util.*;

public class Test {
    static PrintWriter pw = new PrintWriter(System.out);
    static Map<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) {
        int COUNT_OF_TESTS = 1000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            list.add(i);
        }
        for (int i = 0; i < COUNT_OF_TESTS; i++) {
            test(list);
        }
        map.forEach((key, value) -> pw.printf("Answer: %d, count: %d of %d tests\n", key, value, COUNT_OF_TESTS));
        pw.close();
    }

    private static void test(List<Integer> list) {
        Collections.shuffle(list);
        int max = list.get(0);
        int cou = 1;
        for (int i : list) {
            if (i > max) {
                max = i;
                cou++;
            }
        }
        if (map.containsKey(cou)) {
            map.put(cou, map.get(cou) + 1);
        } else {
            map.put(cou, 1);
        }
    }
}

/* output
    Answer: 4, count: 1 of 1000 tests
    Answer: 5, count: 3 of 1000 tests
    Answer: 6, count: 5 of 1000 tests
    Answer: 7, count: 17 of 1000 tests
    Answer: 8, count: 32 of 1000 tests
    Answer: 9, count: 38 of 1000 tests
    Answer: 10, count: 57 of 1000 tests
    Answer: 11, count: 78 of 1000 tests
    Answer: 12, count: 92 of 1000 tests
    Answer: 13, count: 120 of 1000 tests
    Answer: 14, count: 124 of 1000 tests
    Answer: 15, count: 103 of 1000 tests
    Answer: 16, count: 89 of 1000 tests
    Answer: 17, count: 70 of 1000 tests
    Answer: 18, count: 59 of 1000 tests
    Answer: 19, count: 40 of 1000 tests
    Answer: 20, count: 22 of 1000 tests
    Answer: 21, count: 21 of 1000 tests
    Answer: 22, count: 10 of 1000 tests
    Answer: 23, count: 10 of 1000 tests
    Answer: 24, count: 1 of 1000 tests
    Answer: 25, count: 3 of 1000 tests
    Answer: 26, count: 2 of 1000 tests
    Answer: 27, count: 3 of 1000 tests
*/
