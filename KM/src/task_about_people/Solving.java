package task_about_people;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solving {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger n = new BigInteger(sc.nextLine());
        BigInteger m = new BigInteger(sc.nextLine());

//        if (m.equals(BigInteger.ONE.add(BigInteger.ONE))) {
//            solveFor2(n, m);
//            return;
//        }

        if (n.toString().length() <= 3) {
            System.out.printf(
                    "n = %s\nm = %s\nanswer = %s\n",
                    n,
                    m,
                    solveForSmallN(Integer.parseInt(n.toString()), Integer.parseInt(m.toString()))
            );
        } else {
            System.out.printf(
                    "n = %s\nm = %s\nanswer = %s\n",
                    n,
                    m,
                    solveForBigInt(n, m)
            );
        }
    }

    private static void solveFor2(BigInteger n, BigInteger m) {
        BigInteger a = BigInteger.ONE;
        while ((a = a.multiply(m)).compareTo(n) <= 0) ;
        a = a.divide(m);
        System.out.printf(
                "n = %s,\n m = %s,\n answer = %s\n",
                n.toString(),
                m.toString(),
                BigInteger.ONE.add(m.multiply(n.subtract(a)))
        );
    }

    private static int solveForSmallN(int n, int m) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < m - 1; i++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }

//    private static int solveForSmallN(BigInteger n, BigInteger m) {
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < Integer.parseInt(n.toString()); i++) {
//            queue.add(i + 1);
//        }
//        while (queue.size() > 1) {
//            for (int i = 0; i < Integer.parseInt(m.mod(new BigInteger(String.valueOf(queue.size()))).toString()) - 1; i++) {
//                queue.add(queue.poll());
//            }
//            queue.poll();
//        }
//
//        return queue.poll();
//    }

    private static BigInteger solveForBigInt(BigInteger n, BigInteger m) {
        int smallN = 50;
        int smallNAns = solveForSmallN(smallN, Integer.parseInt(m.toString()));
        BigInteger nWithAnswer = new BigInteger(String.valueOf(smallN));
        BigInteger nWithAnswerValue = new BigInteger(String.valueOf(smallNAns));
        while (nWithAnswerValue.add(m).compareTo(nWithAnswer.add(BigInteger.ONE)) <= 0) {
            nWithAnswer = nWithAnswer.add(BigInteger.ONE);
            nWithAnswerValue = nWithAnswerValue.add(m);
        }
        while (n.compareTo(nWithAnswer) > 0) {
            BigInteger newNWithAnswer = (m.multiply(nWithAnswer.add(BigInteger.ONE))
                    .subtract(nWithAnswerValue.add(m).mod(nWithAnswer.add(BigInteger.ONE))))
                    .divide(m.subtract(BigInteger.ONE));

            nWithAnswerValue = newNWithAnswer.subtract(nWithAnswer).multiply(m).add(nWithAnswerValue)
                    .subtract(nWithAnswer.add(BigInteger.ONE));
            nWithAnswer = newNWithAnswer;
        }

        return nWithAnswerValue.subtract(nWithAnswer.subtract(n).multiply(m));
    }
}
