import java.util.Arrays;
import java.util.Scanner;

public class p08_MaxSeqOfIncreasingElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int currentIndex = 0;
        int currentSeq = 1;

        int bestIndex = 0;
        int bestSeq = 0;


        for (int i = 1; i <= numbers.length - 1; i++) {
            if (numbers[i] > numbers[i - 1]) {
                currentSeq++;
                if (currentSeq > bestSeq) {
                    bestSeq = currentSeq;
                    bestIndex = currentIndex;
                }
            } else {
                currentIndex = i;
                currentSeq = 1;
            }
        }

        for (int i = bestIndex; i < bestIndex + bestSeq; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println();
    }
}
