package a_IntroToJavaExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p08_FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt((Integer::parseInt))
                .toArray();

        String[] cmd = scanner.nextLine().split("\\s+");
        int numberOfElements = Integer.parseInt(cmd[1]);
        ArrayList<Integer> oddNums = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (Math.abs(numbers[i]) % 2 == 1) {
                oddNums.add(numbers[i]);
            }
        }

        ArrayList<Integer> evenNums = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNums.add(numbers[i]);
            }
        }

        String type = cmd[2];

        switch (type) {
            case "odd":
                for (int i = 0; i < Math.min(oddNums.size(), numberOfElements); i++) {
                    System.out.printf("%d ", oddNums.get(i));
                }
                break;
            case "even":
                for (int i = 0; i < Math.min(evenNums.size(), numberOfElements); i++) {
                    System.out.printf("%d ", evenNums.get(i));
                }
                break;
        }

    }
}
