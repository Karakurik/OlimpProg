package task_about_people;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
//        solveFor2(2);
//        solveFor3(3);
//        solveFor4(4);
        solveForSmallN(1000, 3);
    }

    private static void solveFor2(int m) {
        for (int n = 1; n < 100; n++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(i + 1);
            }
            while (queue.size() > 1) {
                queue.add(queue.poll());
                queue.poll();
            }
            System.out.printf("n = %d, m = %d, answer = %d\n", n, m, queue.poll());
        }
    }

    private static void solveFor3(int m) {
        for (int n = 1; n < 100; n++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(i + 1);
            }
            while (queue.size() > 1) {
                queue.add(queue.poll());
                queue.add(queue.poll());
                queue.poll();
            }
            System.out.printf("n = %d, m = %d, answer = %d\n", n, m, queue.poll());
        }
    }

    private static void solveFor4(int m) {
        for (int n = 1; n < 100; n++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(i + 1);
            }
            while (queue.size() > 1) {
                queue.add(queue.poll());
                queue.add(queue.poll());
                queue.add(queue.poll());
                queue.poll();
            }
            System.out.printf("n = %d, m = %d, answer = %d\n", n, m, queue.poll());
        }
    }

    private static void solveForSmallN(int nMax, int m) {
        for (int n = 1; n < nMax; n++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.add(i + 1);
            }
            while (queue.size() > 1) {
                for (int i = 0; i < m-1; i++) {
                    queue.add(queue.poll());
                }
                queue.poll();
            }
            System.out.printf("n = %d, m = %d, answer = %d\n", n, m, queue.poll());
        }
    }
}