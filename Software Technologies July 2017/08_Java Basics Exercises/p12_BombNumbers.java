import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p12_BombNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(console.nextLine()
                .split("\\s+")).map(Integer::valueOf)
                .collect(Collectors.toList());


        int[] info = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bombNumber = info[0];
        int bombPower = info[1];

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == bombNumber) {
                int removeFromLeft = Math.max(i - bombPower, 0);
                int removeFromRight = Math.min(i + bombPower, numbers.size() - 1);

                numbers.subList(removeFromLeft, removeFromRight + 1).clear();

                i = -1;
            }
        }

        int sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        System.out.println(sum);
    }


}

