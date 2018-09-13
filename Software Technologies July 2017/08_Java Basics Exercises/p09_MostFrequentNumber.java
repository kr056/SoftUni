import java.util.Arrays;
import java.util.Scanner;

public class p09_MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] result = new int[65540];

        int bestNum = 0;
        int bestCount = 0;

        for (Integer num : numbers) {
            result[num]++;
            if (result[num] > bestCount) {
                bestCount = result[num];
                bestNum = num;
            }
        }

        System.out.println(bestNum);
    }
}
