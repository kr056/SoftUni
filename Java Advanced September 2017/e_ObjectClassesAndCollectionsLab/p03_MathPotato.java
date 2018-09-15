package e_ObjectClassesAndCollectionsLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p03_MathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int hot = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue, input);
        int cycleCount = 0;

        while (queue.size() > 1) {
            for (int i = 1; i < hot; i++) {
                queue.offer(queue.poll());
            }

            cycleCount++;

            if (isPrime(cycleCount)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycleCount) {
        for (int i = 2; i <= Math.sqrt(cycleCount); i++) {
            if (cycleCount % i == 0) {
                return false;
            }

        }
        return !(cycleCount == 0 || cycleCount == 1);
    }
}
