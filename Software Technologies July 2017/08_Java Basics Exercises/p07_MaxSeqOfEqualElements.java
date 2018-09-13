import java.util.Arrays;
import java.util.Scanner;

public class p07_MaxSeqOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt((Integer::parseInt))
                .toArray();

        int bestSeq = 1;
        int bestSeqIndex = 0;

        int currentIndex = 0;
        int currentSeq = 1;

        for (int i = 1; i <= numbers.length - 1; i++) {
            if (numbers[i] == numbers[i - 1]) {
                currentSeq++;
                currentIndex = numbers[i];
            } else {
                currentSeq = 1;
            }

            if (currentSeq > bestSeq) {
                bestSeq = currentSeq;
                bestSeqIndex = currentIndex;
            }

        }

        if (bestSeq == 1) {
            System.out.println(numbers[0]);
        } else {
            for (int i = 0; i < bestSeq; i++) {
                System.out.print(bestSeqIndex + " ");
            }
        }

    }
}
